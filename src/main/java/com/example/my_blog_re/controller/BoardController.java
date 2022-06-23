package com.example.my_blog_re.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.my_blog_re.dto.BoardRequestDto;
import com.example.my_blog_re.model.Board;
import com.example.my_blog_re.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"", "/"})
	public String home() {
		return "home";
	}
	
	@PostMapping("/savePost")
	@ResponseBody
	public String savePost(@RequestBody BoardRequestDto board) {
		boardService.savePost(board);
		return "ok";
	}
	
	// 작성 글 상세 보기
	@GetMapping("/detailPost")
	public String detailPost(int id) {
		return "detail_post";
	}
	
	//
	
	// 글 수정 페이지 호출
	@GetMapping("/update_post_form")
	public String updateForm() {
		return "update_post_form";
	}

}
