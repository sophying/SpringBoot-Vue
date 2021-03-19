package com.example.springBootTest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.springBootTest.model.BoardDto;
import com.example.springBootTest.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@RestController
@RequestMapping("/board")
public class BoardRestController {
//	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);

	@Resource
	BoardService boardService;

//	@CrossOrigin(origins = "http://localhost:8081")
	@ResponseBody
	@GetMapping("/list")
	public List<BoardDto> getBoardList(Model model) {
//		public String getBoardList(Model model) {

		log.info("getBoardList Function - 진입 ");

		try {
			List<BoardDto> boardList = boardService.getBoardList();
//			model.addAttribute("성공", "Success");
			return boardList;
//			return "성공";

		} catch (Exception e) {
			e.printStackTrace();
			log.error("에러 발생 ");
		}
		return null;
	}

}
