package org.zerock.web;

import javax.inject.Inject; // 스프링에서 root-context 참고해서 자동으로 주입
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith; // 스프링 로드
import org.slf4j.Logger; //로그 처리 에러시 로그 표시
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration; //스프링 로드 애노테이션 root-context 설정값에 따라 로딩
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc; //웹에서 가상의 요청과 응답
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration //was 서버 없이 테스트 할 경우 필요
@RunWith(SpringJUnit4ClassRunner.class)//스프링 로드
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) //스프링 로드시 설정파일 경로

public class SampleControllerTest {
	
	 private static final Logger logger =
			LoggerFactory.getLogger(SampleControllerTest.class); //로그 뿌리는 객체
	
  @Inject //이 선언이 있으면 스프링에서 해당 클래스 타입을 찾아서 new로 생성해준다. 때문에 new 객체 생성 구문이 필요 없다.
	 private WebApplicationContext wac;
	
	 private MockMvc mockMvc; // 브라우저에서 요청을 보내고 응답을 받는것을 해주는 객체
	 //테스트라서 브라우저에서 테스트 하지 않으므로 이 녀석이 브라우저같은 역할을 해줌.
	 
	 @Before
	 public void setup1() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build(); //웹서버를 생성해서 브라우저 역할에 보냄.
		
		logger.info("setup........."); 
	 }

	 @Test
	 public void testDoA() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/doA")); //doA에게  get 방식으로 요청을 보낸다.
	 }
	 
}
