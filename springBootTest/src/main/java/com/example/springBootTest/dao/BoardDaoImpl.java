package com.example.springBootTest.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.springBootTest.model.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Resource
	SqlSessionTemplate sqlsessionTemplate;

	@Override
	public List<BoardDto> getBoardList() throws Exception {
		return sqlsessionTemplate.selectList("Board.getBoard_List");
	}

}
