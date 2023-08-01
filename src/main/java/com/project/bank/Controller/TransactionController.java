package com.project.bank.Controller;

import com.project.bank.Dto.Request.OperationRequestDto;
import com.project.bank.Dto.Request.TransactionRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.OperationService;
import com.project.bank.Service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank/transaction")
public class TransactionController {

    private TransactionService transactionService;
    private OperationService operationService;

    public TransactionController(TransactionService transactionService, OperationService operationService) {
        this.transactionService = transactionService;
        this.operationService = operationService;
    }

    @PostMapping("/transaction/transfer")
    public ResponseEntity<ResponseApi>createTransaction(@RequestBody TransactionRequestDto requestDto){
        return transactionService.createTransaction(requestDto);
    }
    @PostMapping("/deposit")
    public ResponseEntity<ResponseApi>deposit(@RequestBody OperationRequestDto requestDto){
        return operationService.deposit(requestDto);
    }
}
