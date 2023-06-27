package jp.ac.hcs.gondo.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Todo {

	private int id;
	
	private String userId;
	
	private String title;
	
	private Date limitDay;
	
	private boolean complate;
	
}
