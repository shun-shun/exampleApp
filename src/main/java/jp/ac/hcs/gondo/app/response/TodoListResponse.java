package jp.ac.hcs.gondo.app.response;

import lombok.Data;

@Data
public class TodoListResponse extends Response {

	private String id;

	private String userId;

	private String title;

	private String limitDay;

	private String complate;

}
