package com.project.bank.Controller;

import com.project.bank.Dto.Request.ClientRequestDto;
import com.project.bank.Dto.Request.EmployeeRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.ClientService;
import com.project.bank.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/bank")
@Validated
public class EmployeeController {

    private EmployeeService employeeService;
    private ClientService clientService;

    public EmployeeController(EmployeeService employeeService, ClientService clientService) {
        this.employeeService = employeeService;
        this.clientService = clientService;
    }

    @PostMapping("/{branchId}/createEmployee")
    public ResponseEntity<ResponseApi> createEmployee(@PathVariable("branchId") String branchId, @Valid @RequestBody EmployeeRequestDto requestDto){
        return employeeService.createEmployee(branchId, requestDto);
    }

    @GetMapping("/{branchId}/getEmployees")
    public ResponseEntity<ResponseApi> getAllByBranchId(@PathVariable("branchId") String branchId){
        return employeeService.getAllbyBranchId(branchId);
    }

    @PostMapping("/{employeeId}/createClient")
    public ResponseEntity<ResponseApi> createClient(@PathVariable("employeeId") String id, @RequestBody ClientRequestDto requestDto){
        return clientService.createClient(id,requestDto);
    }
}
