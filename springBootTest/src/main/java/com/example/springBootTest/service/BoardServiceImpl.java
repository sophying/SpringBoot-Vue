package com.example.springBootTest.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.springBootTest.dao.BoardDao;
import com.example.springBootTest.model.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Resource
	BoardDao boardDao;

	@Override
	public List<BoardDto> getBoardList() throws Exception {
		return boardDao.getBoardList();
	}

}
