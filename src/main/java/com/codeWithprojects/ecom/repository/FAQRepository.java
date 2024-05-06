package com.codeWithprojects.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithprojects.ecom.entity.FAQ;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long>{
	
	List<FAQ> findAllByProductId(Long productsId);
}
