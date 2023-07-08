package jp.ac.hcs.gondo.app.response;

import lombok.Data;

@Data
public class TodoCreatePostResponse extends Response {

	private String reponseCode;
	
	private String status;

	private String message;

}
