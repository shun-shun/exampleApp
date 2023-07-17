package jp.ac.hcs.gondo.app.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TodoSearchPostRequest extends Request {

	@NotEmpty
	private String query;

}
