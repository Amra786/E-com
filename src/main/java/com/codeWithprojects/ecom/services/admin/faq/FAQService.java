package com.codeWithprojects.ecom.services.admin.faq;

import com.codeWithprojects.ecom.dto.FAQDto;

public interface FAQService {
	
	FAQDto postFAQ(Long productId, FAQDto faqDto);

}
