package kr.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;

@Mapper 
public interface BoardMapper {
	
	// 게시글 전체보기
	public ArrayList<Board> boardList();

	// 게시글 작성
	public void boardInsert(Board vo);

	// 게시글 상세보기
	public Board boardContent(int idx);

	// 게시글 삭제
	public void boardDelete(int idx);

	// 게시글 수정
	public void boardUpdate(Board vo);

	// 게시글 조회수 기능
	public void boardCount(int idx);

}






















