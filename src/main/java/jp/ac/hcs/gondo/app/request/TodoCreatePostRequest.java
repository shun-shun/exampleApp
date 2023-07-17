package jp.ac.hcs.gondo.app.request;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TodoCreatePostRequest extends Request{

	@NotBlank(message = "必須項目です")
	@Size(min = 1, max = 100)
	private String title;
	
	@NotBlank(message = "必須項目です")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
}
