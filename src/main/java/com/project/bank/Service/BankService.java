package com.project.bank.Service;

import com.project.bank.Dao.Request.BankRequestDto;
import com.project.bank.Dao.Response.BankResponseDto;
import com.project.bank.Dao.Response.BranchResponseDto;
import com.project.bank.Entity.Bank;
import com.project.bank.Repository.BankRepository;
import com.project.bank.Response.ResponseApi;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class BankService {

    private BankRepository bankRepository;
    private ModelMapper modelMapper;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<ResponseApi> createBank(@Valid BankRequestDto requestDto){
        ResponseApi responseApi = new ResponseApi();
        Optional<Bank> existBank = Optional.ofNullable(bankRepository.findByName(requestDto.getName()));
        try {
            if (existBank.isPresent()) throw new DataIntegrityViolationException("Duplicated data");
            Bank saved = bankRepository.save(modelMapper.map(requestDto, Bank.class));
            responseApi.setMessage("Bank created succesfully");
            responseApi.setStatus(HttpStatus.CREATED.toString());
            responseApi.setData(modelMapper.map(saved, BankResponseDto.class));
            return ResponseEntity.ok(responseApi);
        }catch (DataIntegrityViolationException e){
            responseApi.setMessage("Error at create new Bank");
            responseApi.setStatus(HttpStatus.CONFLICT.toString());
            responseApi.setData(e.getMessage());
            return ResponseEntity.badRequest().body(responseApi);
        }
    }

    public ResponseEntity<ResponseApi> getAll() {
        ResponseApi responseApi = new ResponseApi();
        List<BankResponseDto> list = bankRepository.findAll()
                .stream()
                .map(bank -> modelMapper.map(bank,BankResponseDto.class))
                .collect(Collectors.toList());
        responseApi.setStatus(HttpStatus.OK.toString());
        responseApi.setMessage("All Banks");
        responseApi.setData(list);
        return ResponseEntity.ok(responseApi);
    }

}
