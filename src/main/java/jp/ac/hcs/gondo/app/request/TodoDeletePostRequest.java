package jp.ac.hcs.gondo.app.request;

import lombok.Data;

@Data
public class TodoDeletePostRequest extends Request {

	private String id;
}
