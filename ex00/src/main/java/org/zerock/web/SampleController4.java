package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger logger=
			LoggerFactory.getLogger(SampleController4.class);
	
	/*로깅(Loggin)이란 프로그램 개발이나 운영 시 발생하는 문제점을 추적하거나 운영 상태를 
	모니터링하기 위한 텍스트입니다. 
	로그를 남기기 위한 가장 쉬운 방법은 System.out.println();문을 사용하는 것이며, 
	log4j, slf4j, logback과 같은 로그를 전담하는 프레임워크가 존재합니다.
	*/
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) { //리다이렉트 저장 사용( 결과적으로  doF를 호출)
		logger.info("doE called but redirect to /dpE.....");
		
		rttr.addFlashAttribute("msg", "This is the Message!! with redirected"); 
		//데이터를 하나더 추가해서 전달. 임시데이터로 함수가 끝나면 사라짐.
		
		return "redirect/doF";//아래 컨트롤러함수로 리다이렉트 함.
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute String msg) {
		
		logger.info("doF called......"+ msg);
				
	}
	
}
