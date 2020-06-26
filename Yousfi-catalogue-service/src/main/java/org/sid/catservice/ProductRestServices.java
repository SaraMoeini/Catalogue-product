package org.sid.catservice;

import java.util.List;

import org.sid.catservice.entities.Product;
import org.sid.catservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestServices {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/listProducts")
	public List<Product> listProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/listProducts/{id}")                                                  
	
	public Product listProducts(@PathVariable(name="id") Long id) {
		return productRepository.findById(id).get();
	}

	@PutMapping("/listProducts/{id}")
	public Product update(@PathVariable(name="id") Long id, @RequestBody Product p) {
		p.setId(id);
		return productRepository.save(p);
	}
	
	@PostMapping("/listProducts")
	public Product save(@RequestBody Product p) {
		return productRepository.save(p);
	}

	@DeleteMapping("/listProducts/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		productRepository.deleteById(id);
	}
}
