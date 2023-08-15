package com.project.bank.Controller;

import com.project.bank.Dto.Request.OperationRequestDto;
import com.project.bank.Dto.Request.TransactionRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.OperationService;
import com.project.bank.Service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/bank/transaction")
@Validated
public class TransactionController {

    private TransactionService transactionService;
    private OperationService operationService;

    public TransactionController(TransactionService transactionService, OperationService operationService) {
        this.transactionService = transactionService;
        this.operationService = operationService;
    }

    @PutMapping("/transfer")
    public ResponseEntity<ResponseApi>createTransaction(@RequestBody @Valid TransactionRequestDto requestDto){
        return transactionService.createTransaction(requestDto);
    }
    @PutMapping("/deposit")
    public ResponseEntity<ResponseApi>deposit(@RequestBody @Valid OperationRequestDto requestDto){
        return operationService.deposit(requestDto);
    }
    @PutMapping("/extract")
    public ResponseEntity<ResponseApi>extract(@RequestBody @Valid OperationRequestDto requestDto){
        return operationService.extract(requestDto);
    }
}
