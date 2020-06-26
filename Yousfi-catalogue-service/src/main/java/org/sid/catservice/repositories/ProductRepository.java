package org.sid.catservice.repositories;

import java.util.List;

import org.sid.catservice.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{

	@RestResource(path="/byDesignation")
	public List<Product> findByDesignationContains(@Param("motcle") String des);

	@RestResource(path="/byDesignationPage")
	public List<Product> findByDesignationContains(@Param("motcle") String des,Pageable pageable );

}
