package com.simple.playdata.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersVO {

	private String id;
	private String pw;
	private String name;
	private String couseinfo;
	private String phone;
	
}
