package jp.ac.hcs.gondo.app.response;

import lombok.Data;

@Data
public class TodoUpdateResponse extends Response {

	private String reponseCode;
	
	private String status;

	private String message;

}
