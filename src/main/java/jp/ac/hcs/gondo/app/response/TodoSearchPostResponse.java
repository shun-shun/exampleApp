package jp.ac.hcs.gondo.app.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TodoSearchPostResponse extends Response {

	private String id;

	private String userId;

	private String title;

	private String limitDay;

	private String complete;
	
}
