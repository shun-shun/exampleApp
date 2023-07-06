package jp.ac.hcs.gondo.domain.repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;

public interface UpdateRepository {

	int update(TodoData data);
	
}
