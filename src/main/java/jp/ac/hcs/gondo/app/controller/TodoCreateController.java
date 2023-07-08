package jp.ac.hcs.gondo.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.ac.hcs.gondo.app.request.TodoCreatePostRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.domain.service.FindService;

@Controller
public class TodoCreateController {

	@Autowired
	private Map<String, FindService> service;
	
	private static final String MODEL_NAME = "response";
	
	@GetMapping("/create")
	public String getApply(TodoCreatePostRequest request, Model model) {
		model.addAttribute("request", request);
		return "todo/create";
	}
	
	@PostMapping("/create")
	public String postApply(@Validated TodoCreatePostRequest request, Model model) {
		Response response = service.get("TodoCreateService").execute(request);
		model.addAttribute(MODEL_NAME, response);
		return "redirect:/search";
	}
}
