package com.project.bank.Service;

import com.project.bank.Dto.Response.CurrentAccoutResponseDto;
import com.project.bank.Entity.Client;
import com.project.bank.Entity.Current_Account;
import com.project.bank.Repository.ClientRepository;
import com.project.bank.Repository.CurrentAccountRepository;
import com.project.bank.Response.ResponseApi;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.project.bank.Utils.AccountNumberGenerator.accountNumberGenerator;

@Service
public class CurrentAccountService {

    private ClientRepository clientRepository;
    private CurrentAccountRepository currentAccountRepository;
    private ModelMapper modelMapper;

    public CurrentAccountService(ClientRepository clientRepository, CurrentAccountRepository currentAccountRepository) {
        this.clientRepository = clientRepository;
        this.currentAccountRepository = currentAccountRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<ResponseApi>createCurrentAccount(String clientId){
        ResponseApi responseApi = new ResponseApi();
        Optional<Client> client = clientRepository.findById(clientId);
        try {
            if (client.isEmpty()) throw new EntityNotFoundException("Client with id "+clientId+" not found");

            Current_Account account = new Current_Account();
            account.setAccount_number(accountNumberGenerator());
            account.setBalance(0);
            account.setOpening_date(new Date());
            account.setClient(client.get());
            account.setBranch(client.get().getBranch());

            responseApi.setStatus(HttpStatus.CREATED.toString());
            responseApi.setMessage("Current account created succesfully");

            responseApi.setData(modelMapper.map(currentAccountRepository.save(account), CurrentAccoutResponseDto.class));
            return ResponseEntity.ok(responseApi);
        }catch (EntityNotFoundException e){
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setMessage("Error");
            responseApi.setData(e.getMessage());

            return ResponseEntity.badRequest().body(responseApi);
        }
    }

    public ResponseEntity<ResponseApi> getCurrentAccounts(String id){
        ResponseApi responseApi = new ResponseApi();
        Optional<Client> client = clientRepository.findById(id);
        try {
            if(client.isEmpty()) throw new EntityNotFoundException("Client with id " + id + " not found");

            List<CurrentAccoutResponseDto> accounts = currentAccountRepository.findByClient_id(id)
                    .stream()
                    .map(current_account -> modelMapper.map(current_account,CurrentAccoutResponseDto.class))
                    .collect(Collectors.toList());

            responseApi.setStatus(HttpStatus.OK.toString());
            responseApi.setMessage("All Current Accounts from Client: " + id);
            responseApi.setData(accounts);
            return ResponseEntity.ok(responseApi);
        }catch (EntityNotFoundException e){
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setMessage("Error");
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }
}
