package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map; //Map<String, Object> myMap = new HashMap<String, Object>();
//와 같이 Generic을 Key와 Data형으로 지정합니다. 키와 값이 있는 리스트라고 생각하면 된다.

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO; //도메인 작성 클래스 가져옴 (도메인은 DB나 테이블 단위를 의미 또는 시스템 단위)

//인터페이스 구현 

@Repository//DAO를 스프링에 인식시키기 위해 사용하는 애노테이션
public class MemberDAOImpl implements MemberDAO{ //뒤쪽 영어는 implement의 약자
	
	@Inject//스프링에서 클래스를 찾아서 자동으로 NEW 생성
	private SqlSession sqlSession;//mybatis-spring에서 지원하는 sqlsessiontemplete 클래스, 
	
	private static final String namespace =
			"org.zerock.mapper.MemberMapper"; //sql을 저장한 메퍼에서 사용되는 네임스페이스
	
	@Override//함수 구현시 사용
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");		
	}
	
	@Override
	public void insertMember(MemberVO vo) {
	 sqlSession.insert(namespace+".insertMember",vo);
	}	
	
	
	@Override
	public MemberVO readMember(String userid) throws Exception {
		return (MemberVO) 
				sqlSession.selectOne(namespace+".selectMember", userid);
	}


	@Override
	public MemberVO readWithPW(String userid, String pw) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", pw);
		
		return sqlSession.selectOne(namespace+".readWithPW", paramMap);
	}

}
