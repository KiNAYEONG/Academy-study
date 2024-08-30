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
	// 가변성이 있어서 ArrayList로 Board를 가져온다.
	// Board를 하나만 가져올 순 없다. 여러개를 가져와야지~~
	// 추상클래스를 가질 수 있는건 추상메소드나 인터페이스라서 인터페이스 채택!


	
	@Select("SELECT * FROM BOARD ORDER BY INDATE DESC")
	public ArrayList<Board> boardList();

	//게시글 작성
	//vo 안의 문장은 소문자이니 #뒤의 글자는 소문자로 작성!
	@Insert("INSERT INTO BOARD(TITLE, CONTENT, WRITER) VALUES(#{title}, #{content}, #{writer})")
	public void boardInsert(Board vo);
	
	//게시글 상세보기
	@Select("SELECT * FROM BOARD WHERE IDX = #{idx}")
	public Board boardContent(int idx);
	
	//게시글 삭제
	@Delete("DELETE FROM BOARD WHERE IDX = #{idx}")
	
	//게시글 수정
	@Update("UPDATE BOARD SET TITLE=#{title},CONTENT=#{content},WRITER=#{writer} WHERE IDX = #{idx}")
	public void boardUpdate(Board vo);

	//조회수 기능
	@Update("UPDATE BOARD SET COUNT = COUNT+1 WHERE IDX= #{idx}")
	public void boardCount(int idx);
}

