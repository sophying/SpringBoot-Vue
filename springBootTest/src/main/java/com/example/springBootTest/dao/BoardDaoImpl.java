package com.example.springBootTest.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.springBootTest.model.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Resource
	SqlSessionTemplate sqlsessionTemplate;

	@Override
	public List<BoardDto> getBoardList() throws Exception {
		return sqlsessionTemplate.selectList("Board.getBoard_List");
	}

	@Override
//	public boolean boardInsert() throws Exception {
	public boolean boardInsert(BoardDto boardDto) {
			System.out.println("DaoImpl >>>>  진입");
			System.out.println(boardDto.getBoardTitle());
			System.out.println(boardDto.getBoardWriter());
			System.out.println(boardDto.getIdx());
		try {
			int result = sqlsessionTemplate.insert("Board.Board_Insert", boardDto);
			if (result > 0) {
				System.out.println(result);
				return true;
			}
		} catch (SqlSessionException sqlException) {
			sqlException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;

	}

}
