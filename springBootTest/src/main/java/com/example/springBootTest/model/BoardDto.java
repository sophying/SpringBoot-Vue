package com.example.springBootTest.model;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NonNull;

@Data
public class BoardDto {
	@NonNull private int idx;
	@NonNull private String board_title;
	@NonNull private String board_writer;
	@NonNull private Date board_regdate;



}
