package jp.ac.hcs.gondo.domain.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.request.TodoDetailRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.app.response.TodoSearchPostResponse;
import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.entity.Todo;
import jp.ac.hcs.gondo.domain.repository.FindRepository;
import jp.ac.hcs.gondo.domain.service.FindService;

@Service("TodoFindService")
public class TodoFindService implements FindService {

	@Autowired
	private Map<String, FindRepository> repository;

	@Override
	public Response execute(Request request) {
		TodoData todoData = modeling(request);
		Todo todoList = repository.get("SelectIdRepositoryImpl").find(todoData);
		Response response = modeling(todoList);
		return response;
	}

	private TodoData modeling(Request request) {
		if (!(request instanceof TodoDetailRequest)) {
			throw new IllegalArgumentException();
		}
		TodoDetailRequest findRequest = (TodoDetailRequest) request;
		TodoData todoData = new TodoData();
		todoData.setId(Integer.parseInt(findRequest.getId()));
		return todoData;
	}

	private Response modeling(Todo todo) {
		TodoSearchPostResponse response = new TodoSearchPostResponse();
		response.setId(String.valueOf(todo.getId()));
		response.setUserId(todo.getUserId());
		response.setTitle(todo.getTitle());
		response.setLimitDay(todo.getLimitDay().toString());
		response.setComplete(Boolean.toString(todo.isComplete()));
		return response;
	}

}
