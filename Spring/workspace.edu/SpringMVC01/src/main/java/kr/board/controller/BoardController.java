package kr.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller // 해당 클래스가 Controller이 되기위해 어노테이션 명시
public class BoardController {

	// Mapper Interface 사용하기
	// Autowired의 역할 : 객체를 가져오겠다.
	@Autowired
	private BoardMapper mapper;
	
	// 게시글 수정 기능
	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) {
		System.out.println("게시글 수정 기능");
		mapper.boardUpdate(vo);//문자열이 아니라 java니까 vo.getIdx()
		return "redirect:/boardContent.do?idx="+vo.getIdx();
	}
	
	// 게시글 수정화면 이동 기능
	@RequestMapping("/boardUpdateForm.do")
	public String boardUpdateForm(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 수정화면 이동 기능");
		Board vo = mapper.boardContent(idx); //idx에 맞는 6가지 정보 보여주기
		model.addAttribute("vo",vo); //model에 저장	
		return "boardUpdateForm";
	}

	// 게시글 삭제 기능
		@RequestMapping("/boardDelete.do")	
		//1개만 가져올거니까 @RequestParam을 쓴다. url 뒤의 idx를 int에 넣어주겠다.
		public String boardDelete(@RequestParam("idx") int idx) {
			System.out.println("게시글 삭제 기능");
			//Board vo는 지워준다. 삭제만 하면 되니까~
			mapper.boardDelete(idx);
			
			return "redirect:/boardList.do";
		}
		
	// 게시글 상세보기 기능
	@RequestMapping("/boardContent.do")
	// Model에 저장할거니까 Model 클래스 model 매개변수
	public String boardContent(@RequestParam("idx") int idx, Model model) {
		System.out.println("게시글 상세보기 기능");
		mapper.boardCount(idx);
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo",vo);
		return "boardContent";
	}
	
	
	// 게시글 작성 기능
	// 기본 생성자가 vo에 반드시 있어야한다.
	@RequestMapping("boardInsert.do")
	public String boardInsert(Board vo) {
		mapper.boardInsert(vo);		
		// Board vo = new Board();
		// vo.setTitle(request.getParameter("title");
		// vo.setContent(request.getParameter("content");
		// vo.setContent(request.getParameter("writer");		
		return "redirect:/boardList.do";//redirect 후 뒤에 url 적기
	}
	
	
	// 게시판 글쓰기 페이지 이동 
	// 컨트롤러랑 SSFB 잇는 역할
	@RequestMapping("/boardForm.do")
	public String boardForm() {
		System.out.println("게시판 글쓰기 이동");
		return "boardForm";
	}

	
	// 게시판 전체조회
	@RequestMapping("/boardList.do") // 해당 url로 요청이 왔을 때 아래 메소드를 실행하겠다.
	public String boardList(Model model) {

		// 게시글 정보 가져오기
		// 게시글 - 번호, 제목, 내용, 작성자, 작성일, 조회수
		ArrayList<Board> list = mapper.boardList();
		model.addAttribute("list", list);

		// Forward 방식의 페이지 이동
		return "boardList";
	}

	// Controller는 마지막에 view name을 돌려줌.
	// WEB-INF/views.boardList.jsp

}
