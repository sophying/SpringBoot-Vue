package com.example.springBootTest.dao;

import java.util.List;

import com.example.springBootTest.model.BoardDto;

public interface BoardDao {

	List<BoardDto> getBoardList() throws Exception;


}
