package jp.ac.hcs.gondo.domain.service;

import java.util.List;

import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.response.Response;

public interface TodoListService {

	List<Response> execute(Request request);
	
}
