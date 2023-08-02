package com.project.bank.Controller;

import com.project.bank.Dto.Request.BranchRequestDto;
import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.BrachService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/bank")
@Validated
public class BranchController {

    private BrachService brachService;

    public BranchController(BrachService brachService) {
        this.brachService = brachService;
    }

    @PostMapping("/{name}/createbranch")
    public ResponseEntity<ResponseApi> crateBranch(@PathVariable("name") String bankName, @RequestBody @Valid BranchRequestDto requestDto){
        return brachService.createBranch(bankName,requestDto);
    }

    @GetMapping("/{name}/getbranches")
    public ResponseEntity<ResponseApi> getAllBranches(@PathVariable("name") String bankName){
        return brachService.getAll(bankName);
    }

}
