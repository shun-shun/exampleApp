package jp.ac.hcs.gondo.app.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TodoSearchPostRequest extends Request {

	@NotEmpty
	private String query;

}
