package com.example.my_blog_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.my_blog_project.dto.BoardSaveRequestDto;
import com.example.my_blog_project.model.Board;
import com.example.my_blog_project.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	// 메인 화면 (게시글 출력)
	@GetMapping({"", "/", "/list"})
	public String list(@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable,
			Model model) {
		Page<Board> boards = boardService.showPostList(pageable);
		model.addAttribute("boards", boardService.showPostList(pageable));
		return "home";
	}
	
	// 글쓰기 화면 이동
	@GetMapping("/savePostForm")
	public String savePostForm() {
		return "savePostForm";
	}
	
	// 글 저장하기
	@PostMapping("/savePost")
	@ResponseBody
	public String savePost(@RequestBody BoardSaveRequestDto board) {
		boardService.savePost(board);
		return "ok";
	}	
	
	// 작성 글 상세 보기
	@GetMapping("/detailPost")
	public String detailPost(int id) {
		return "detailPostForm";
	}
	
	// 글 수정 페이지 호출
	@GetMapping("/update_post_form")
	public String updateForm() {
		return "update_post_form";
	}

}
