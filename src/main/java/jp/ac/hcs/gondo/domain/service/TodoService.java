package jp.ac.hcs.gondo.domain.service;

import jp.ac.hcs.gondo.app.request.Request;
import jp.ac.hcs.gondo.app.response.Response;

public interface TodoService {

	Response execute(Request request);
	
}
