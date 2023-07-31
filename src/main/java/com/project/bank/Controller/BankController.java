package com.project.bank.Controller;

import com.project.bank.Dao.Request.BankRequestDto;
import com.project.bank.Dao.Request.BranchRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.BankService;
import com.project.bank.Service.BrachService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankController {

    private BankService bankService;
    private BrachService brachService;

    public BankController(BankService bankService, BrachService brachService) {
        this.bankService = bankService;
        this.brachService = brachService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseApi> createBank(@RequestBody BankRequestDto requestDto){
        return bankService.createBank(requestDto);
    }
    @PostMapping("/{name}/createbranch")
    public ResponseEntity<ResponseApi>crateBranch(@PathVariable("name") String bankName, @RequestBody BranchRequestDto requestDto){
        return brachService.createBranch(bankName,requestDto);
    }
}
