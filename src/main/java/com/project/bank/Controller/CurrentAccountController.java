package com.project.bank.Controller;

import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.CurrentAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class CurrentAccountController {

    private CurrentAccountService currentAccountService;

    public CurrentAccountController(CurrentAccountService currentAccountService) {
        this.currentAccountService = currentAccountService;
    }

    @PostMapping("/client/{id}/createCurrentAccount")
    public ResponseEntity<ResponseApi> createCurrentAccount(@PathVariable("id") String clientId){
        return currentAccountService.createCurrentAccount(clientId);
    }
}
