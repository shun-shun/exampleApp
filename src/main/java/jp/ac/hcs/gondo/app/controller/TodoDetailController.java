package jp.ac.hcs.gondo.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import jp.ac.hcs.gondo.app.common.StringUtils;
import jp.ac.hcs.gondo.app.request.TodoDetailRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.domain.service.FindService;

@Controller
public class TodoDetailController {

	@Autowired
	private Map<String, FindService> service;
	
	@GetMapping("/detail")
	public String getDetail(@Validated TodoDetailRequest request, Model model) {
		Response response = service.get("TodoFindService").execute(request);
		model.addAttribute(StringUtils.MODEL_NAME, response);
		return "todo/detail";
	}
}
