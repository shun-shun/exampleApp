package jp.ac.hcs.gondo.domain.repository;

import jp.ac.hcs.gondo.domain.dto.StatusCode;
import jp.ac.hcs.gondo.domain.dto.TodoData;

public interface UpdateRepository {

	StatusCode update(TodoData data);
	
}
