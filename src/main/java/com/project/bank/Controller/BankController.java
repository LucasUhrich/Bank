package com.project.bank.Controller;

import com.project.bank.Dto.Request.BankRequestDto;
import com.project.bank.Dto.Request.BranchRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.BankService;
import com.project.bank.Service.BrachService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bank")
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseApi> createBank(@RequestBody BankRequestDto requestDto){
        return bankService.createBank(requestDto);
    }
    @GetMapping("/getall")
    public ResponseEntity<ResponseApi> getAllBanks(){
        return bankService.getAll();
    }

}
