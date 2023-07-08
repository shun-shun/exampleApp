package jp.ac.hcs.gondo.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.ac.hcs.gondo.app.common.StringUtils;
import jp.ac.hcs.gondo.app.request.TodoCreatePostRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.domain.service.FindService;

@Controller
public class TodoCreateController {

	@Autowired
	private Map<String, FindService> service;
	
	@GetMapping("/create")
	public String getApply(TodoCreatePostRequest request, Model model) {
		model.addAttribute("request", request);
		return "todo/create";
	}
	
	@PostMapping("/create")
	public String postApply(@Validated TodoCreatePostRequest request, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return getApply(request, model);
		}
		
		Response response = service.get("TodoCreateService").execute(request);
		model.addAttribute(StringUtils.MODEL_NAME, response);
		return "redirect:/";
	}
}
