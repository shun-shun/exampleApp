package jp.ac.hcs.gondo.app.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TodoDeletePostRequest extends Request {

	@Pattern(regexp = "^[0-9]{1,6}$")
	private String id;
}
