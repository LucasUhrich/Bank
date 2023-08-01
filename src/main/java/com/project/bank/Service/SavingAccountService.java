package com.project.bank.Service;

import com.project.bank.Dto.Request.SavingAccountRequestDto;
import com.project.bank.Dto.Response.CurrentAccoutResponseDto;
import com.project.bank.Dto.Response.SavingAccoutResponseDto;
import com.project.bank.Entity.Client;
import com.project.bank.Entity.Current_Account;
import com.project.bank.Entity.Saving_Account;
import com.project.bank.Repository.ClientRepository;
import com.project.bank.Repository.SavingAccountRepository;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Utils.AccountNumberGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Optional;

import static com.project.bank.Utils.AccountNumberGenerator.accountNumberGenerator;

@Service
public class SavingAccountService {

    private SavingAccountRepository savingAccountRepository;
    private ModelMapper modelMapper;
    private ClientRepository clientRepository;

    public SavingAccountService(SavingAccountRepository savingAccountRepository, ClientRepository clientRepository) {
        this.savingAccountRepository = savingAccountRepository;
        this.modelMapper = new ModelMapper();
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<ResponseApi> createSavingAccount(String clientId, SavingAccountRequestDto requestDto){
        ResponseApi responseApi = new ResponseApi();
        Optional<Client> client = clientRepository.findById(clientId);
        try {
            if (client.isEmpty()) throw new EntityNotFoundException("Client with id "+clientId+" not found");

            Saving_Account account = modelMapper.map(requestDto,Saving_Account.class);
            account.setAccount_number(accountNumberGenerator());
            account.setBalance(0);
            account.setOpening_date(new Date());
            account.setClient(client.get());
            account.setBranch(client.get().getBranch());

            responseApi.setStatus(HttpStatus.CREATED.toString());
            responseApi.setMessage("Saving account created succesfully");
            responseApi.setData(modelMapper.map(savingAccountRepository.save(account),SavingAccoutResponseDto.class));
            return ResponseEntity.ok(responseApi);
        }catch (EntityNotFoundException e){
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setMessage("Error");
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }
}
