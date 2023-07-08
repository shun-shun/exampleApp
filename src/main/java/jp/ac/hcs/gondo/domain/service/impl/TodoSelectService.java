package jp.ac.hcs.gondo.domain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.hcs.gondo.app.common.SecurityUtil;
import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.request.TodoSearchPostRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.app.response.TodoSearchPostResponse;
import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.entity.Todo;
import jp.ac.hcs.gondo.domain.repository.SelectRepository;
import jp.ac.hcs.gondo.domain.service.ListService;

@Service("TodoSelectService")
public class TodoSelectService implements ListService {

	@Autowired
	private Map<String, SelectRepository> repository;

	@Override
	public List<Response> execute(Request request) {
		TodoData todoData = modeling(request);
		List<Todo> todoList = repository.get("SelectUserIdReposotiyImpl").select(todoData);
		List<Response> response = modeling(todoList);
		return response;
	}

	private TodoData modeling(Request request) {
		if (!(request instanceof TodoSearchPostRequest)) {
			throw new IllegalArgumentException();
		}
		
		TodoSearchPostRequest selectRequest = (TodoSearchPostRequest) request;
		TodoData todoData = new TodoData();
		todoData.setQuery(selectRequest.getQuery());
		todoData.setUserId(SecurityUtil.getUsername());
		return todoData;
	}

	private List<Response> modeling(List<Todo> todos) {
		List<Response> responseList = new ArrayList<>();
		for (Todo todo : todos) {
			TodoSearchPostResponse response = new TodoSearchPostResponse();
			response.setId(String.valueOf(todo.getId()));
			response.setUserId(todo.getUserId());
			response.setTitle(todo.getTitle());
			response.setLimitDay(todo.getLimitDay().toString());
			response.setComplete(Boolean.toString(todo.isComplete()));
			responseList.add(response);
		}
		return responseList;
	}
}
