package com.franquia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.franquia.model.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Long>{

}
