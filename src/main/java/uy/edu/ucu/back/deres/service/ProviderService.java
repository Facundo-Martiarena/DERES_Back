package uy.edu.ucu.back.deres.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.repository.ProviderRepository;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;


}
