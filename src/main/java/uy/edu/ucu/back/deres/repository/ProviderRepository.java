package uy.edu.ucu.back.deres.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uy.edu.ucu.back.deres.entity.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    Provider findByRut(String rut);

}
