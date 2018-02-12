package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO; // 정의 클래스 생성한 새로만든 패키지 경로

@Controller
public class SampleController3 {

	private static final Logger logger =
			LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping("/doD")
	public String doD(Model model) {
		
		ProductVO product= new ProductVO("Sample Product", 10000);
		
		logger.info("doD");
		
		model.addAttribute(product);
					
		return "ProductDetail";
	}
	
}
