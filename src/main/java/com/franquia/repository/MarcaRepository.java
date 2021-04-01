package com.franquia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.franquia.model.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Long>{

}
