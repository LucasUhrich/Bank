package com.project.bank.Controller;

import com.project.bank.Dto.Request.SavingAccountRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.SavingAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bank")
public class SavingAccountController {
    private SavingAccountService savingAccountService;

    public SavingAccountController(SavingAccountService savingAccountService) {
        this.savingAccountService = savingAccountService;
    }

    @PostMapping("/client/{id}/createSavingAccount")
    public ResponseEntity<ResponseApi> createSavingAccount(@PathVariable("id") String clientId, @RequestBody SavingAccountRequestDto requestDto) {
        return savingAccountService.createSavingAccount(clientId, requestDto);
    }

    @GetMapping("/client/{id}/getSavingAccounts")
    public ResponseEntity<ResponseApi> getAccounts(@PathVariable("id") String id) {
        return savingAccountService.getSavingAccounts(id);
    }
}
