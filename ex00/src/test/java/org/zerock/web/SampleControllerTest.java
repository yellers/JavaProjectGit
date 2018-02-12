package org.zerock.web;

import javax.inject.Inject; // ���������� root-context �����ؼ� �ڵ����� ����
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith; // ������ �ε�
import org.slf4j.Logger; //�α� ó�� ������ �α� ǥ��
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration; //������ �ε� �ֳ����̼� root-context �������� ���� �ε�
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc; //������ ������ ��û�� ����
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration //was ���� ���� �׽�Ʈ �� ��� �ʿ�
@RunWith(SpringJUnit4ClassRunner.class)//������ �ε�
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //������ �ε�� �������� ���

public class SampleControllerTest {
	
	 private static final Logger logger =
			LoggerFactory.getLogger(SampleControllerTest.class); //�α� �Ѹ��� ��ü
	
  @Inject //�� ������ ������ ���������� �ش� Ŭ���� Ÿ���� ã�Ƽ� new�� �������ش�. ������ new ��ü ���� ������ �ʿ� ����.
	 private WebApplicationContext wac;
	
	 private MockMvc mockMvc; // ���������� ��û�� ������ ������ �޴°��� ���ִ� ��ü
	 //�׽�Ʈ�� ���������� �׽�Ʈ ���� �����Ƿ� �� �༮�� ���������� ������ ����.
	 
	 @Before
	 public void setup1() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build(); //�������� �����ؼ� ������ ���ҿ� ����.
		
		logger.info("setup........."); 
	 }

	 @Test
	 public void testDoA() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/doA")); //doA����  get ������� ��û�� ������.
	 }
	 
}
