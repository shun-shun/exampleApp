package jp.ac.hcs.gondo.domain.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TodoData {

	private int id;
	
	private String userId;
	
	private String title;
	
	private Date limitDay;
	
	private boolean complate;
}
