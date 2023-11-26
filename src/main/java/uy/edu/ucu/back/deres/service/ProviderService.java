package uy.edu.ucu.back.deres.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.edu.ucu.back.deres.entity.Provider;
import uy.edu.ucu.back.deres.model.ResponseOK;
import uy.edu.ucu.back.deres.model.provider.ProviderRequestDTO;
import uy.edu.ucu.back.deres.repository.ProviderRepository;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getProviders() {
        try {
            return providerRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener proveedores de la base de datos.", e);
        }
    }

    public ResponseOK addProvider(ProviderRequestDTO provider) {
        try {
            var providerEntity = Provider.builder()
                    .name(provider.getName())
                    .rut(provider.getRUT())
                    .type(provider.getType())
                    .score(provider.getScore())
                    .build();
            providerRepository.save(providerEntity);
            return new ResponseOK(true);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar proveedor a la base de datos.", e);
        }
    }

    public Provider getProvider(String rut) {
        try {
            return providerRepository.findByRut(rut);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener proveedor de la base de datos.", e);
        }
    }
}
