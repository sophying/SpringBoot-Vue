package com.example.springBootTest.service;

import java.util.List;

import com.example.springBootTest.model.BoardDto;

public interface BoardService {

	List<BoardDto> getBoardList() throws Exception;

	public boolean boardInsert(BoardDto boardDto) throws Exception;
}
