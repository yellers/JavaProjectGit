package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map; //Map<String, Object> myMap = new HashMap<String, Object>();
//�� ���� Generic�� Key�� Data������ �����մϴ�. Ű�� ���� �ִ� ����Ʈ��� �����ϸ� �ȴ�.

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO; //������ �ۼ� Ŭ���� ������ (�������� DB�� ���̺� ������ �ǹ� �Ǵ� �ý��� ����)

//�������̽� ���� 

@Repository//DAO�� �������� �νĽ�Ű�� ���� ����ϴ� �ֳ����̼�
public class MemberDAOImpl implements MemberDAO{ //���� ����� implement�� ����
	
	@Inject//���������� Ŭ������ ã�Ƽ� �ڵ����� NEW ����
	private SqlSession sqlSession;//mybatis-spring���� �����ϴ� sqlsessiontemplete Ŭ����, 
	
	private static final String namespace =
			"org.zerock.mapper.MemberMapper"; //sql�� ������ ���ۿ��� ���Ǵ� ���ӽ����̽�
	
	@Override//�Լ� ������ ���
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
