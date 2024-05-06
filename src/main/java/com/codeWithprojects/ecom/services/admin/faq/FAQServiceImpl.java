package com.codeWithprojects.ecom.services.admin.faq;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeWithprojects.ecom.dto.FAQDto;
import com.codeWithprojects.ecom.entity.FAQ;
import com.codeWithprojects.ecom.entity.Product;
import com.codeWithprojects.ecom.repository.FAQRepository;
import com.codeWithprojects.ecom.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {

	private final FAQRepository faqRepository;
	
	private final ProductRepository productRepository;
	
	public FAQDto postFAQ(Long productId, FAQDto faqDto) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isPresent()) {
			FAQ faq = new FAQ();
			
			faq.setQuestion(faqDto.getQuestion());
			faq.setAnswer(faq.getAnswer());
			faq.setProduct(optionalProduct.get());
			
			return faqRepository.save(faq).getFAQDto();
		}
		return null;
	}
}
