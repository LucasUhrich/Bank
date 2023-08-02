package com.project.bank.Service;

import com.project.bank.Dto.Request.OperationRequestDto;
import com.project.bank.Dto.Response.OperationResponseDto;
import com.project.bank.Entity.Account;
import com.project.bank.Entity.Current_Account;
import com.project.bank.Entity.Operation;
import com.project.bank.Entity.Saving_Account;
import com.project.bank.Enum.AccountType;
import com.project.bank.Enum.OperationType;
import com.project.bank.Repository.ClientRepository;
import com.project.bank.Repository.CurrentAccountRepository;
import com.project.bank.Repository.OperationRepository;
import com.project.bank.Repository.SavingAccountRepository;
import com.project.bank.Response.ResponseApi;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;
@Service
@Validated
public class OperationService {
    private CurrentAccountRepository currentAccountRepository;
    private SavingAccountRepository savingAccountRepository;
    private ModelMapper modelMapper;
    private OperationRepository operationRepository;

    public OperationService(CurrentAccountRepository currentAccountRepository, SavingAccountRepository savingAccountRepository, OperationRepository operationRepository) {
        this.currentAccountRepository = currentAccountRepository;
        this.savingAccountRepository = savingAccountRepository;
        this.operationRepository = operationRepository;
        this.modelMapper = new ModelMapper();
    }

    private Optional<Account> getAccount(OperationRequestDto requestDto){
        if(requestDto.getAccount_type().equals(AccountType.CURRENT)){
            return Optional.ofNullable(currentAccountRepository.findByAccount_number(requestDto.getAccount()));
        }
        return Optional.ofNullable(savingAccountRepository.findByAccount_number(requestDto.getAccount()));
    }

    private Account addMoney(Account account, double mount){
        if (account instanceof Current_Account){
            account.setBalance(account.getBalance()+mount);
            return currentAccountRepository.save((Current_Account) account);
        }
        if (account instanceof Saving_Account){
            account.setBalance(account.getBalance()+mount);
            return savingAccountRepository.save((Saving_Account) account);
        }
        return null;
    }

    private void validateDepositMount(double mount){
        if(mount < 0) throw new ArithmeticException("Invalid mount");
    }

    private Account removeMoney(Account account, double mount){
        if (account instanceof Current_Account){
            account.setBalance(account.getBalance()-mount);
            return currentAccountRepository.save((Current_Account) account);
        }
        if (account instanceof Saving_Account){
            account.setBalance(account.getBalance()-mount);
            return savingAccountRepository.save((Saving_Account) account);
        }
        return null;
    }

    private void validateExtractMount(Account account ,double mount){
        if (mount < 0 || mount > account.getBalance()) throw new ArithmeticException("Invalid mount");
    }

    public ResponseEntity<ResponseApi> deposit(@Valid OperationRequestDto requestDto){
        ResponseApi responseApi = new ResponseApi();
        Optional<Account> account = getAccount(requestDto);
        try {
            if (account.isEmpty()) throw new EntityNotFoundException("Account " + requestDto.getAccount() + " not found");
            validateDepositMount(requestDto.getMount());
            addMoney(account.get(), requestDto.getMount());

            Operation operation = modelMapper.map(requestDto,Operation.class);
            operation.setOperation_type(OperationType.DEPOSIT);
            operation.setBank(account.get().getBranch().getBank());
            operation.setBranch(account.get().getBranch());

            responseApi.setMessage(HttpStatus.OK.toString());
            responseApi.setMessage("Deposit $"+ requestDto.getMount()+" succesfully");
            responseApi.setData(modelMapper.map(operationRepository.save(operation), OperationResponseDto.class));
            return ResponseEntity.ok(responseApi);
        }catch (EntityNotFoundException | ArithmeticException e){
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setMessage("Error");
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }

    public ResponseEntity<ResponseApi> extract(@Valid OperationRequestDto requestDto){
        ResponseApi responseApi = new ResponseApi();
        Optional<Account> account = getAccount(requestDto);
        try {
            if (account.isEmpty()) throw new EntityNotFoundException("Account " + requestDto.getAccount() + " not found");
            validateExtractMount(account.get(),requestDto.getMount());

            removeMoney(account.get(), requestDto.getMount());

            Operation operation = modelMapper.map(requestDto,Operation.class);
            operation.setOperation_type(OperationType.EXTRACT);
            operation.setBank(account.get().getBranch().getBank());
            operation.setBranch(account.get().getBranch());

            responseApi.setMessage(HttpStatus.OK.toString());
            responseApi.setMessage("Extract $"+ requestDto.getMount()+" succesfully");
            responseApi.setData(modelMapper.map(operationRepository.save(operation), OperationResponseDto.class));
            return ResponseEntity.ok(responseApi);
        }catch (EntityNotFoundException | ArithmeticException e){
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setMessage("Error");
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }

}
