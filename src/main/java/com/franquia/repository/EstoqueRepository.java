package com.franquia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.franquia.model.Estoque;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Long>  {

	

}