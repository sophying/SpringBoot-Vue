package com.example.springBootTest.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BoardDto {
	// @JsonProperty 를  활용할 경우 property 에 활용된 name은  vue에서도 사용해야할 변수이다.
	// @JsonProperty 를 사용하지 않는다면 board_title 가 아닌 boardTitle 가 출력될 변수라 생각하면 됨.
	// 현재 vue 는 @JsonProperty 에 사용된 board_title 로 활용되고 있음.
	@JsonProperty("idx")
	private int idx;

	@JsonProperty("board_title")
	private String boardTitle;

	@JsonProperty("board_writer")
	private String boardWriter;

	@JsonProperty("board_regdate")
	private Date boardRegdate;

}
