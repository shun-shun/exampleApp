package jp.ac.hcs.gondo.domain.repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;

public interface TodoUpdateRepository {

	int update(TodoData data);
	
}
