package jp.ac.hcs.gondo.app.controller;


import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.ac.hcs.gondo.app.common.StringUtils;
import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.request.TodoSearchPostRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.domain.service.ListService;

@Controller
public class TodoSelectController {

	@Autowired
	private Map<String, ListService> service;

	@GetMapping("/")
	public String getDashboard(Model model) {
		List<Response> response = service.get("TodoSelectAllService").execute(new Request());
		model.addAttribute(StringUtils.MODEL_NAME, response);
		return "todo/dashboard";
	}
	
	@PostMapping("/search")
	public String postSearch(@Validated TodoSearchPostRequest request, BindingResult result, Principal principal, Model model) {
		if(result.hasErrors()) {
			return getDashboard(model);
		}
		
		List<Response> response = service.get("TodoSearchService").execute(request);
		model.addAttribute(StringUtils.MODEL_NAME, response);
		return "todo/dashboard";
	}
}
