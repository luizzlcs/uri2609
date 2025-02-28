package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CategorySumProjection> categorySum = repository.search1();
		List<CategorySumDTO> list = categorySum.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());

		System.out.println("\n === RESULTADO SQL RAÍZ ===");
		for (CategorySumDTO categorySumProjection : list) {

			System.out.println(categorySumProjection);
			// System.out.println(categorySumProjection.getSum());
			
		}

		System.out.println("\n === RESULTADO JPQL ===");
		List<CategorySumDTO> categoryDTO = repository.search2();

		for (CategorySumDTO categorySumDTO : categoryDTO) {
			System.out.println(categorySumDTO);
			// System.out.println(categorySumDTO.getSum());
			
		}

	}
}
