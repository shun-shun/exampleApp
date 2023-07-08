package jp.ac.hcs.gondo.domain.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.request.TodoDeletePostRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.app.response.TodoCreatePostResponse;
import jp.ac.hcs.gondo.domain.dto.StatusCode;
import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.UpdateRepository;
import jp.ac.hcs.gondo.domain.service.FindService;

@Service("TodoDeleteService")
public class TodoDeleteService implements FindService {

	@Autowired
	private Map<String, UpdateRepository> repository;
	
	@Override
	public Response execute(Request request) {
		TodoData todoData = modeling(request);
		StatusCode statusCode = repository.get("DeleteRepositoryImpl").update(todoData);
		Response response = modeling(statusCode);
		return response;
	}
	
	private TodoData modeling(Request request) {
		if (!(request instanceof TodoDeletePostRequest)) {
			throw new IllegalArgumentException();
		}

		TodoDeletePostRequest selectRequest = (TodoDeletePostRequest) request;
		TodoData todoData = new TodoData();
		todoData.setId(Integer.parseInt(selectRequest.getId()));
		return todoData;
	}

	
	private Response modeling(StatusCode statusCode) {
		TodoCreatePostResponse response = new TodoCreatePostResponse();
		response.setReponseCode(String.valueOf(statusCode.getCode()));
		response.setMessage(statusCode.getMessage());
		response.setStatus(statusCode.name());
		return response;
	}

}
