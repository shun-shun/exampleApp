package jp.ac.hcs.gondo.app.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TodoUpdatePostRequest extends Request {

	@Pattern(regexp = "^[0-9]{1,6}$")
	private String id;
}
