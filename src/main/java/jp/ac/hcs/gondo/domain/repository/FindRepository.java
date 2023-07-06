package jp.ac.hcs.gondo.domain.repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.entity.Todo;

public interface FindRepository {
	
	Todo find(TodoData data);
	
}
