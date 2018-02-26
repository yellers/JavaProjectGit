package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO dao; //해당 인터페이스에 맞는 new 객체 할당. 인터페이스 이므로 구현된 MembberDAOImpli가 들어가 것이다.
	
	@Test
	public void testTime()throws Exception{
		
		System.out.println(dao.getTime());
		
	}
	
	@Test
	public void testInsertMember()throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aaa.com");
		
		dao.insertMember(vo);
		
	}	

	

}


