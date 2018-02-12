package org.zerock.web;

import org.slf4j.Logger; 
/*로깅(Loggin)이란 프로그램 개발이나 운영 시 발생하는 문제점을 추적하거나 운영 상태를 
모니터링하기 위한 텍스트입니다. 
로그를 남기기 위한 가장 쉬운 방법은 System.out.println();문을 사용하는 것이며, 
log4j, slf4j, logback과 같은 로그를 전담하는 프레임워크가 존재합니다.
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller//스프링 MVC의 컨트롤러 객체임을 명시하는 애노테이션
public class SampleController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")//특정 uri에 매칭되는 클래스나 메소드임을 명시하는 애노테이션 
	public void doA() {
		
		logger.info("doA called...........");
	}
	
	@RequestMapping("doB")
	public void doB(){
		
		logger.info("doB called.......");
	
	}
}