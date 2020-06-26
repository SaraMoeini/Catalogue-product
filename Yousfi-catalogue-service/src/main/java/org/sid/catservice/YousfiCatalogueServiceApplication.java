package org.sid.catservice;

import org.sid.catservice.entities.Product;
import org.sid.catservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class YousfiCatalogueServiceApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository; 
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration; 
	
	public static void main(String[] args) {
		SpringApplication.run(YousfiCatalogueServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		productRepository.save(new Product(null,"PC", 7000,5));
		productRepository.save(new Product(null,"Printer HP", 3000, 4));
		productRepository.save(new Product(null,"Printer Epson", 2000, 3));
		productRepository.save(new Product(null,"Smart Phone Samsung", 8000, 12));
		productRepository.save(new Product(null,"Camera",2500,2));
		productRepository.save(new Product(null,"LapTop",1500,1));
		
		productRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
	}

}
