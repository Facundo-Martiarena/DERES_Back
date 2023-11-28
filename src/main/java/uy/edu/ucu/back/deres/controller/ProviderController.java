package uy.edu.ucu.back.deres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uy.edu.ucu.back.deres.entity.Provider;
import uy.edu.ucu.back.deres.model.provider.ProviderRequestDTO;
import uy.edu.ucu.back.deres.model.provider.ProviderResponseDTO;
import uy.edu.ucu.back.deres.service.ProviderService;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping("/addProvider")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    private ProviderResponseDTO addProvider(@RequestBody ProviderRequestDTO providerAddRequestDTO){
        return providerService.addProvider(providerAddRequestDTO);
    }

    @GetMapping("/providers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private List<Provider> getProviders() throws Exception {
        return providerService.getProviders();
    }

    @GetMapping("/providers/{rut}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    private Provider getProvider(@PathVariable("rut") String rut) throws Exception {
        return providerService.getProvider(rut);
    }

}
