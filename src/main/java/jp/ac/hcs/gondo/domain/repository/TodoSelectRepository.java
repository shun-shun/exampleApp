package jp.ac.hcs.gondo.domain.repository;

import java.util.List;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.entity.Todo;

public interface TodoSelectRepository {

	List<Todo> select(TodoData data);
	
}
