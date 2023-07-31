package com.project.bank.Controller;

import com.project.bank.Dao.Request.BankRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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


}
