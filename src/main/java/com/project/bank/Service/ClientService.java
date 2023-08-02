package com.project.bank.Service;

import com.project.bank.Dto.Request.ClientRequestDto;
import com.project.bank.Dto.Response.ClientResponseDto;
import com.project.bank.Entity.*;
import com.project.bank.Enum.Rol;
import com.project.bank.Repository.*;
import com.project.bank.Response.ResponseApi;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private BranchRepository branchRepository;
    private ClientRepository clientRepository;
    private CurrentAccountRepository currentAccountRepository;
    private SavingAccountRepository savingAccountRepository;

    public ClientService(EmployeeRepository employeeRepository, BranchRepository branchRepository, ClientRepository clientRepository, CurrentAccountRepository currentAccountRepository, SavingAccountRepository savingAccountRepository) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = new ModelMapper();
        this.branchRepository = branchRepository;
        this.clientRepository = clientRepository;
        this.currentAccountRepository = currentAccountRepository;
        this.savingAccountRepository = savingAccountRepository;
    }

    public ResponseEntity<ResponseApi> createClient(String employeeId, ClientRequestDto clientRequestDto){
        ResponseApi responseApi = new ResponseApi();
        Optional<Client> existClient = Optional.ofNullable(clientRepository.findByEmail(clientRequestDto.getEmail()));
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        try {
            if(employee.isEmpty()) throw new EntityNotFoundException("Employee with id " + employeeId + " not found");
            if (existClient.isPresent()) throw new DataIntegrityViolationException("Client with email " + clientRequestDto.getEmail() + " already exists");

            Client client = modelMapper.map(clientRequestDto, Client.class);
            client.setActive(true);
            client.setRol(Rol.CLIENT);
            client.setRegistration(new Date());
            client.setBranch(employee.get().getBranch());

            responseApi.setMessage("Client created succesfully");
            responseApi.setStatus(HttpStatus.CREATED.toString());
            responseApi.setData(modelMapper.map(clientRepository.save(client), ClientResponseDto.class));

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
            List<ClientResponseDto> list = clientRepository.findByBranch_id(id)
                    .stream()
                    .map(client -> modelMapper.map(client, ClientResponseDto.class))
                    .collect(Collectors.toList());
            responseApi.setStatus(HttpStatus.OK.toString());
            responseApi.setMessage("All Clients from Branch: " + id);
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
