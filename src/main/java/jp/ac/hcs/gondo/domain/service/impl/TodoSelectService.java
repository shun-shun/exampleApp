package jp.ac.hcs.gondo.domain.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.domain.entity.Todo;
import jp.ac.hcs.gondo.domain.repository.TodoSelectRepository;
import jp.ac.hcs.gondo.domain.service.TodoListService;

@Service("TodoSelectService")
public class TodoSelectService implements TodoListService {
	
	@Autowired
	private Map<String, TodoSelectRepository> repository;

	@Override
	public List<Response> execute(Request request) {
		List<Todo> todoList = repository.get("SelectUserIdReposotiyImpl").select();
		return null;
	}
	
//	private TodoData modeling(Request request) {
//		if(!(request instanceof TodoSelectRequest)) {
//			throw new IllegalArgumentException();
//		}
//		
//	}

}
