package jp.ac.hcs.gondo.app.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TodoCreatePostRequest extends Request{

	@NotBlank
	private String title;
	
	private String date;
}
