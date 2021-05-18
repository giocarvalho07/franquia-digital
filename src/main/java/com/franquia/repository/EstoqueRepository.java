package com.franquia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.franquia.model.Estoque;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Long>  {

	

}