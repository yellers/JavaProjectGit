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
	
	/*�α�(Loggin)�̶� ���α׷� �����̳� � �� �߻��ϴ� �������� �����ϰų� � ���¸� 
	����͸��ϱ� ���� �ؽ�Ʈ�Դϴ�. 
	�α׸� ����� ���� ���� ���� ����� System.out.println();���� ����ϴ� ���̸�, 
	log4j, slf4j, logback�� ���� �α׸� �����ϴ� �����ӿ�ũ�� �����մϴ�.
	*/
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) { //�����̷�Ʈ ���� ���( ���������  doF�� ȣ��)
		logger.info("doE called but redirect to /dpE.....");
		
		rttr.addFlashAttribute("msg", "This is the Message!! with redirected"); 
		//�����͸� �ϳ��� �߰��ؼ� ����. �ӽõ����ͷ� �Լ��� ������ �����.
		
		return "redirect/doF";//�Ʒ� ��Ʈ�ѷ��Լ��� �����̷�Ʈ ��.
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute String msg) {
		
		logger.info("doF called......"+ msg);
				
	}
	
}
