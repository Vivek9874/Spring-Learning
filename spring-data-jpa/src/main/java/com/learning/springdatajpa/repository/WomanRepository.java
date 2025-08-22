package com.learning.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.springdatajpa.model.Woman;

@Repository
public interface WomanRepository extends JpaRepository<Woman, Integer> {
	
	//removing the below annotation won't affect the outcome, since JPA uses Domain Specific language. But it is hit or miss, so better use annotation
	@Query("select w from Woman w where w.name = ?1")
	List<Woman> findByName(String name);
	
	
	//in the below example we did not require to write a JPQL query, the method creations was handled by JPA
	List<Woman> findBySize(String size);

}
