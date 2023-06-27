package jp.ac.hcs.gondo.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.domain.service.TodoService;

@Controller
public class TodoCreateController {

	@Autowired
	private Map<String, TodoService> service;
	
	private static final String MODEL_NAME = "response";
	
	@GetMapping("/create")
	public String getApply() {
		return "apply/input";
	}
	
	@PostMapping("/create")
	public String postApply(@ModelAttribute Request request, Model model) {
		Response response = service.get("TodoCreateService").execute(request);
		model.addAttribute(MODEL_NAME, response);
		return "index";
	}
}
