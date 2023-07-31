package com.project.bank.Controller;

import com.project.bank.Response.ResponseApi;
import com.project.bank.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/branch/{id}/getAllClients")
    public ResponseEntity<ResponseApi>getAllClientsByBranchId(@PathVariable("id") String id){
        return clientService.getAllbyBranchId(id);
    }
}
