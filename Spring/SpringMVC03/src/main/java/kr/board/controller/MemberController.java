package kr.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

@Controller
public class MemberController {
	@Autowired
	private MemberMapper mapper;

	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "member/joinForm";
	}

	@RequestMapping("/registerCheck.do")
	public @ResponseBody int registerCheck(@RequestParam("id") String id) {
		Member m = mapper.registerCheck(id);

		if (m != null) {
			return 0; // 이미 회원이 존재 임의로 0으로 쓴 것.
		} else {
			return 1; // 사용가능한 ID
		}		
	}
	
	@RequestMapping("/join.do")
	public String join(Member m) {
		mapper.join(m);
		return "redirect:/"; //index.do로 가려면 /만 있으면 됨.
		// url 바뀔 때마다 새로 쓰는건 귀찮으니까 그냥 redirect:/로 써줌.
		// index라고 써도 되나 상단의 url은 join.do로 표시될 것
		// 아니면 /controller~~ 이렇게 써도 되는데 url 바뀌면 고쳐줘야 함.
		// 결론 : 리다이렉트 써라~~
	}
	
}
