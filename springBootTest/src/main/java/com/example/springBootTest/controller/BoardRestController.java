package com.example.springBootTest.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/board/*")
public class BoardRestController {
//	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);

	@Resource
	BoardService boardService;

//	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/list")
	public List<BoardDto> getBoardList(Model model) {
//		public String getBoardList(Model model) {

		log.info("getBoardList Function - 진입  ########");

		try {
			List<BoardDto> boardList = boardService.getBoardList();
			// 값 insert 되었는지 출력 테스트
			if (!(boardList.isEmpty())) {
				Iterator<BoardDto> iterator = boardList.iterator();
				while (iterator.hasNext()) {
					BoardDto boardDto = (BoardDto) iterator.next();
					System.out.println("  Idx > "+boardDto.getIdx());
					System.out.println("  BoardTitle > "+boardDto.getBoardTitle());
					System.out.println("  BoardWriter > "+boardDto.getBoardWriter());
					System.out.println("  BoardRegdate > "+boardDto.getBoardRegdate());

				}
			}// 출력 테스트 끝
			return boardList;

		} catch (Exception e) {
			e.printStackTrace();
			log.error("에러 발생 ");
		}
		return null;
	}


	@PostMapping("/insert")
	public String getBoardInsert(BoardDto boardDto) {
		log.info("getBoardInsert Function - 진입 >>>>>>>>>>>>");

		System.out.println(boardDto.getIdx() + " ///////  ");
		System.out.println(boardDto.getBoardTitle() + " ///////  ");
		System.out.println(boardDto.getBoardWriter() + " ///////  ");
		System.out.println(boardDto.getBoardRegdate() + " ///////  ");

		boardDto.setIdx(6);
		boardDto.setBoardTitle("title 6666");
		boardDto.setBoardWriter("writer 6666");

		System.out.println(boardDto.getIdx() + " ///////  ");
		System.out.println(boardDto.getBoardTitle() + " ///////  ");
		System.out.println(boardDto.getBoardWriter() + " ///////  ");
		System.out.println(boardDto.getBoardRegdate() + " ///////  ");
		try {
			boolean result = boardService.boardInsert(boardDto);
			if (result) {
				log.info(result + "테이블 insert 성공 ------------");
				return "redirect:/board/list";
			}
		} catch (SqlSessionException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		// insert 만 진행한 뒤 다시 게시판으로 넘어오기 위함.
		return "redirect:/board/list";
	}

}
