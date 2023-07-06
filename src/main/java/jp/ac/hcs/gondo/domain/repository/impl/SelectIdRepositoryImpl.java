package jp.ac.hcs.gondo.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.BaseFindRepository;

@Repository("SelectIdRepositoryImpl")
public class SelectIdRepositoryImpl extends BaseFindRepository {

	@Override
	protected String createSql() {
		String sql = "SELECT * FROM t_task WHERE id = :id ORDER BY id";
		return sql;
	}

	@Override
	protected Map<String, Object> createParams(TodoData todoData) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", todoData.getId());
		return params;
	}

}
