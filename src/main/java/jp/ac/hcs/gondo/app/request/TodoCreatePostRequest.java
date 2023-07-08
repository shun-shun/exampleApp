package jp.ac.hcs.gondo.app.request;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TodoCreatePostRequest extends Request{

	@NotBlank
	@Size(min = 1, max = 100)
	private String title;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
}
