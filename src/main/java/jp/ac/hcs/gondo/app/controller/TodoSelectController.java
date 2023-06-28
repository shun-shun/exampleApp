package jp.ac.hcs.gondo.app.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import jp.ac.hcs.gondo.app.request.TodoSelectRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.domain.service.TodoListService;

@Controller
public class TodoSelectController {

	@Autowired
	private Map<String, TodoListService> service;

	private static final String MODEL_NAME = "response";

	@GetMapping("/todo/select")
	public String getSelect(@Validated TodoSelectRequest request, Principal principal, Model model) {
		List<Response> response = service.get("TodoSelectService").execute(request);
		model.addAttribute(MODEL_NAME, response);
		return "todo/select";
	}
}
