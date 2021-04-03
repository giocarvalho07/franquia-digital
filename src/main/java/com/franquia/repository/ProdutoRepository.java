package com.franquia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.franquia.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
