package jp.ac.hcs.gondo.app.request;

import lombok.Data;

@Data
public class TodoSearchPostRequest extends Request {

	private String userId;
	
	private String query;

}
