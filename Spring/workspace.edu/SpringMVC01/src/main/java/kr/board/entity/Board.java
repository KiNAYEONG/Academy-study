package kr.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data				//자동완성을 하는게 좋을 걸~~
@AllArgsConstructor //전체 매개변수 받는 생성자 만들기
@NoArgsConstructor  //매개변수 없는 생성자도 추가로 만들어야함.
@ToString 			//안에 있는것들을 저장하는 용도
public class Board {
	private int idx;         //번호
	private String title;    //제목
	private String content;  //내용
	private String writer;   //작성자
	private String indate;   //작성일
	private int count; 	     //조회수
	
}
