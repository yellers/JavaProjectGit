package org.zerock.web;

import org.slf4j.Logger; 
/*�α�(Loggin)�̶� ���α׷� �����̳� � �� �߻��ϴ� �������� �����ϰų� � ���¸� 
����͸��ϱ� ���� �ؽ�Ʈ�Դϴ�. 
�α׸� ����� ���� ���� ���� ����� System.out.println();���� ����ϴ� ���̸�, 
log4j, slf4j, logback�� ���� �α׸� �����ϴ� �����ӿ�ũ�� �����մϴ�.
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller//������ MVC�� ��Ʈ�ѷ� ��ü���� ����ϴ� �ֳ����̼�
public class SampleController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")//Ư�� uri�� ��Ī�Ǵ� Ŭ������ �޼ҵ����� ����ϴ� �ֳ����̼� 
	public void doA() {
		
		logger.info("doA called...........");
	}
	
	@RequestMapping("doB")
	public void doB(){
		
		logger.info("doB called.......");
	
	}
}