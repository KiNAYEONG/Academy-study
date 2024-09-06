package kr.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Member;

@Mapper
public interface MemberMapper {

	//아이디 중복검사
	public Member registerCheck(String id);

	// 회원가입
	public void join(Member m);
	
}
