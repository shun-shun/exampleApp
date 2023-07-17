package jp.ac.hcs.gondo.app.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TodoCreatePostResponse extends Response {

	private String reponseCode;
	
	private String status;

	private String message;

}
