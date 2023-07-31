package com.project.bank.Service;

import com.project.bank.Dao.Request.BankRequestDto;
import com.project.bank.Dao.Request.BranchRequestDto;
import com.project.bank.Dao.Response.BranchResponseDto;
import com.project.bank.Entity.Bank;
import com.project.bank.Entity.Branch;
import com.project.bank.Repository.BankRepository;
import com.project.bank.Repository.BranchRepository;
import com.project.bank.Response.ResponseApi;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class BrachService {

    private BranchRepository branchRepository;
    private BankRepository bankRepository;

    private ModelMapper modelMapper;
    public BrachService(BranchRepository branchRepository, BankRepository bankRepository) {
        this.branchRepository = branchRepository;
        this.bankRepository = bankRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<ResponseApi> createBranch(String bankName, @Valid BranchRequestDto requestDto){
        ResponseApi responseApi = new ResponseApi();
        Optional<Bank> bank = Optional.ofNullable(bankRepository.findByName(bankName));
        try {
            if (bank.isEmpty()) throw new EntityNotFoundException("Bank " + bankName + " not found");
            Branch branch = modelMapper.map(requestDto,Branch.class);
            branch.setBank(bank.get());
            responseApi.setStatus(HttpStatus.CREATED.toString());
            responseApi.setMessage("Branch created Succesfully");
            responseApi.setData(modelMapper.map(branchRepository.save(branch), BranchResponseDto.class));
            return ResponseEntity.ok(responseApi);
        }catch (EntityNotFoundException e){
            responseApi.setStatus(HttpStatus.NOT_FOUND.toString());
            responseApi.setMessage("Error");
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }
}
