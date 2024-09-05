package kr.board.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@RequestMapping("/board/*")
@RestController
public class BoardController {

	@Autowired
	private BoardMapper mapper;
	
	@GetMapping("/all")
	public ArrayList<Board> boardList(){
		return mapper.boardList();
	}
	
	@GetMapping("/{idx}")
	public Board boardContent(@PathVariable("idx") int idx) {
		return mapper.boardContent(idx);
	}
	
	@PostMapping("/new")
	public void boardInsert(Board vo) {
		mapper.boardInsert(vo);
	}
	
	@DeleteMapping("/{idx}")
	public void boardDelete(@PathVariable("idx") int idx) {
		mapper.boardDelete(idx);
	}
	
	@PutMapping("/update")
	public void boardUpdate(@RequestBody Board vo) {
		mapper.boardUpdate(vo);
	}
	
	@PutMapping("/{idx}")
	public void boardCount(@PathVariable("idx") int idx) {
		mapper.boardCount(idx);
	}
	
	
	
	
}






