package com.project.bank.Controller;

import com.project.bank.Dao.Request.BankRequestDto;
import com.project.bank.Dao.Request.BranchRequestDto;
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
    private BrachService brachService;

    public BankController(BankService bankService, BrachService brachService) {
        this.bankService = bankService;
        this.brachService = brachService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseApi> createBank(@RequestBody BankRequestDto requestDto){
        return bankService.createBank(requestDto);
    }
    @GetMapping("/getall")
    public ResponseEntity<ResponseApi> getAllBanks(){
        return bankService.getAll();
    }
    @PostMapping("/{name}/createbranch")
    public ResponseEntity<ResponseApi>crateBranch(@PathVariable("name") String bankName, @RequestBody BranchRequestDto requestDto){
        return brachService.createBranch(bankName,requestDto);
    }

    @GetMapping("/{name}/getbranches")
    public ResponseEntity<ResponseApi> getAllBranches(@PathVariable("name") String bankName){
        return brachService.getAll(bankName);
    }
}
