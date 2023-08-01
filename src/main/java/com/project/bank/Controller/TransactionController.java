package com.project.bank.Controller;

import com.project.bank.Dto.Request.TransactionRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class TransactionController {

    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<ResponseApi>currentAccountTransaction(@RequestBody TransactionRequestDto requestDto){
        return transactionService.createTransaction(requestDto);
    }
}
