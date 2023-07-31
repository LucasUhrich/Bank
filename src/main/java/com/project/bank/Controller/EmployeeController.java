package com.project.bank.Controller;

import com.project.bank.Dto.Request.EmployeeRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bank")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/{branchId}/createEmployee")
    public ResponseEntity<ResponseApi> createEmployee(@PathVariable("branchId") String branchId, @RequestBody EmployeeRequestDto requestDto){
        return employeeService.createEmployee(branchId, requestDto);
    }

    @GetMapping("/{branchId}/getEmployees")
    public ResponseEntity<ResponseApi> getAllByBranchId(@PathVariable("branchId") String branchId){
        return employeeService.getAllbyBranchId(branchId);
    }
}
