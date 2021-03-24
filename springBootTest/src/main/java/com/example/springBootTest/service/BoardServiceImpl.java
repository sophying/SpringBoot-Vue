package com.example.springBootTest.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.springBootTest.dao.BoardDao;
import com.example.springBootTest.model.BoardDto;

import lombok.extern.log4j.Log4j;

@Service
public class BoardServiceImpl implements BoardService {

	@Resource
	BoardDao boardDao;

	@Override
	public List<BoardDto> getBoardList() throws Exception {
		return boardDao.getBoardList();
	}

	@Override
	public boolean boardInsert(BoardDto boardDto) throws Exception {
		System.out.println("serviceImpl >>>>  진입");
		boolean result = boardDao.boardInsert(boardDto);
		if (result) {
			return true;
		}else {
			return false;
		}
	}

}
