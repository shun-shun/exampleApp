package jp.ac.hcs.gondo.domain.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.hcs.gondo.app.common.SecurityUtil;
import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.request.TodoCreatePostRequest;
import jp.ac.hcs.gondo.app.response.Response;
import jp.ac.hcs.gondo.app.response.TodoCreatePostResponse;
import jp.ac.hcs.gondo.domain.dto.StatusCode;
import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.UpdateRepository;
import jp.ac.hcs.gondo.domain.service.FindService;

@Service("TodoCreateService")
public class TodoCreateService implements FindService {

	@Autowired
	private Map<String, UpdateRepository> repository;

	@Override
	public Response execute(Request request) {
		TodoData todoData = modeling(request);
		StatusCode statusCode = repository.get("InsertRepositoryImpl").update(todoData);
		Response response = modeling(statusCode);
		return response;
	}

	private TodoData modeling(Request request) {
		if (!(request instanceof TodoCreatePostRequest)) {
			throw new IllegalArgumentException();
		}

		TodoCreatePostRequest selectRequest = (TodoCreatePostRequest) request;
		TodoData todoData = new TodoData();
		todoData.setTitle(selectRequest.getTitle());

		// String型からDate型へ変換する
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			todoData.setLimitDay(format.parse(selectRequest.getDate()));
		} catch (ParseException e) {
			throw new IllegalArgumentException();
		}
		
		todoData.setUserId(SecurityUtil.getUsername());
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
