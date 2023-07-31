package com.project.bank.Service;

import com.project.bank.Dto.Request.BankRequestDto;
import com.project.bank.Dto.Request.EmployeeRequestDto;
import com.project.bank.Dto.Response.BankResponseDto;
import com.project.bank.Dto.Response.BranchResponseDto;
import com.project.bank.Dto.Response.EmployeeResponseDto;
import com.project.bank.Entity.Bank;
import com.project.bank.Entity.Branch;
import com.project.bank.Entity.Employee;
import com.project.bank.Enum.Rol;
import com.project.bank.Repository.BranchRepository;
import com.project.bank.Repository.EmployeeRepository;
import com.project.bank.Response.ResponseApi;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private BranchRepository branchRepository;

    public EmployeeService(EmployeeRepository employeeRepository, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = new ModelMapper();
        this.branchRepository = branchRepository;
    }

    public ResponseEntity<ResponseApi> createEmployee(String branchId, @Valid EmployeeRequestDto employeeRequestDto){
        ResponseApi responseApi = new ResponseApi();
        Optional<Employee> existEmployee = Optional.ofNullable(employeeRepository.findByEmail(employeeRequestDto.getEmail()));
        Optional<Branch> branch = branchRepository.findById(branchId);
        try {
            if(branch.isEmpty()) throw new EntityNotFoundException("Branch with id " + branchId + " not found");
            if (existEmployee.isPresent()) throw new DataIntegrityViolationException("Employee with email " + employeeRequestDto.getEmail() + " already exists");

            Employee employee = modelMapper.map(employeeRequestDto, Employee.class);
            employee.setActive(true);
            employee.setBranch(branch.get());
            employee.setRol(Rol.EMPLOYEE);
            employee.setRegistration(new Date());

            responseApi.setMessage("Bank created succesfully");
            responseApi.setStatus(HttpStatus.CREATED.toString());
            responseApi.setData(modelMapper.map(employeeRepository.save(employee), EmployeeResponseDto.class));
            return ResponseEntity.ok(responseApi);
        }catch (DataIntegrityViolationException e){
            responseApi.setMessage("Error");
            responseApi.setStatus(HttpStatus.CONFLICT.toString());
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }catch (EntityNotFoundException e){
            responseApi.setMessage("Error");
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }

    public ResponseEntity<ResponseApi> getAllbyBranchId(String id){
        ResponseApi responseApi = new ResponseApi();
        Optional<Branch> branch = branchRepository.findById(id);
        try {
            if(branch.isEmpty()) throw new EntityNotFoundException("Branch with id " + id + " not found");
            List<EmployeeResponseDto> list = employeeRepository.findByBranch_id(id)
                    .stream()
                    .map(employee -> modelMapper.map(employee, EmployeeResponseDto.class))
                    .collect(Collectors.toList());
            responseApi.setStatus(HttpStatus.OK.toString());
            responseApi.setMessage("All Employees from " + id);
            responseApi.setData(list);
            return ResponseEntity.ok(responseApi);
        }catch (EntityNotFoundException e){
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setMessage("Error");
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }
}
