package com.project.bank.Service;

import com.project.bank.Dto.Request.OperationRequestDto;
import com.project.bank.Dto.Request.TransactionRequestDto;
import com.project.bank.Dto.Response.TransactionResponseDto;
import com.project.bank.Entity.*;
import com.project.bank.Enum.AccountType;
import com.project.bank.Enum.OperationType;
import com.project.bank.Repository.*;
import com.project.bank.Response.ResponseApi;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private CurrentAccountRepository currentAccountRepository;
    private SavingAccountRepository savingAccountRepository;
    private ClientRepository clientRepository;
    private ModelMapper modelMapper;

    public TransactionService(TransactionRepository transactionRepository, CurrentAccountRepository currentAccountRepository, SavingAccountRepository savingAccountRepository, ClientRepository clientRepository) {
        this.transactionRepository = transactionRepository;
        this.currentAccountRepository = currentAccountRepository;
        this.savingAccountRepository = savingAccountRepository;
        this.clientRepository = clientRepository;
        this.modelMapper =new ModelMapper();
    }

    private void validateSenderAccount(Optional sender, TransactionRequestDto requestDto){
        if (sender.isEmpty()) throw new EntityNotFoundException("Current account "+ requestDto.getSender_account() +" not found");
    }

    private void validateReceiverAccount(Optional receiver, TransactionRequestDto requestDto){
        if (receiver.isEmpty()) throw new EntityNotFoundException("Current account "+requestDto.getReceive_account()+" not found");
    }

    private void validateAccounts(Optional sender,Optional receiver,TransactionRequestDto requestDto){
        validateSenderAccount(sender,requestDto);
        validateReceiverAccount(receiver,requestDto);
    }

    private void validationMount(double senderMount, double transaction){
        if (transaction < 0 || transaction > senderMount)throw new ArithmeticException("Invalid Mount");
    }

    private Optional<Account> getSenderAccount(TransactionRequestDto requestDto){
        if (requestDto.getAccount_type().equals(AccountType.CURRENT)){
            return Optional.ofNullable(currentAccountRepository.findByAccount_number(requestDto.getSender_account()));
        }
        return Optional.ofNullable(savingAccountRepository.findByAccount_number(requestDto.getSender_account()));
    }

    private Optional<Account>getReceiverAccount(TransactionRequestDto requestDto){
        if (requestDto.getAccount_type().equals(AccountType.CURRENT)){
            return Optional.ofNullable(currentAccountRepository.findByAccount_number(requestDto.getReceive_account()));
        }
        return Optional.ofNullable(savingAccountRepository.findByAccount_number(requestDto.getReceive_account()));
    }

    private void save(Optional sender, Optional receiver){
        if(sender.get() instanceof Current_Account){
            currentAccountRepository.save((Current_Account) sender.get());
            currentAccountRepository.save((Current_Account) receiver.get());
        }
        if (sender.get() instanceof Saving_Account){
            savingAccountRepository.save((Saving_Account) sender.get());
            savingAccountRepository.save((Saving_Account) receiver.get());
        }
    }

    public ResponseEntity<ResponseApi> createTransaction(@Valid TransactionRequestDto requestDto){
        ResponseApi responseApi = new ResponseApi();
        Optional<Account> sender = getSenderAccount(requestDto);
        Optional<Account> receiver = getReceiverAccount(requestDto);
        try {
            validateAccounts(sender,receiver,requestDto);
            validationMount(sender.get().getBalance(), requestDto.getBalance());

            sender.get().setBalance(sender.get().getBalance() - requestDto.getBalance());
            receiver.get().setBalance(receiver.get().getBalance() + requestDto.getBalance());

            save(sender,receiver);

            Transaction saved = modelMapper.map(requestDto, Transaction.class);
            saved.setBranch(sender.get().getBranch());
            saved.setBank(sender.get().getBranch().getBank());

            responseApi.setStatus(HttpStatus.OK.toString());
            responseApi.setMessage("Transaction realized succesfully");
            responseApi.setData(modelMapper.map(transactionRepository.save(saved), TransactionResponseDto.class));
            return ResponseEntity.ok(responseApi);
        }catch (EntityNotFoundException | ArithmeticException e){
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setMessage("Error");
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }
}
