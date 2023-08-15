package com.project.bank.Controller;

import com.project.bank.Dto.Request.BankRequestDto;
import com.project.bank.Dto.Request.BranchRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.BankService;
import com.project.bank.Service.BrachService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/bank")
@Validated
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseApi> createBank(@RequestBody @Valid BankRequestDto requestDto){
        return bankService.createBank(requestDto);
    }
    @GetMapping("/getall")
    public ResponseEntity<ResponseApi> getAllBanks(){
        return bankService.getAll();
    }

}
