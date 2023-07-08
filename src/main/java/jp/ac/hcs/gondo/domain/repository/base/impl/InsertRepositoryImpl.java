package jp.ac.hcs.gondo.domain.repository.base.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.base.BaseUpdateRepository;

@Repository("InsertRepositoryImpl")
public class InsertRepositoryImpl extends BaseUpdateRepository {

	@Override
	protected String createSql() {
		String sql = "INSERT INTO t_task(id, user_id, title, limit_day, complete) VALUES((SELECT MAX(id) + 1 FROM t_task), :userId, :title, :limitday, false)";
		return sql;
	}

	@Override
	protected Map<String, Object> createParams(TodoData todoData) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", todoData.getUserId());
		params.put("title", todoData.getTitle());
		params.put("limitday", todoData.getLimitDay());
		return params;
	}
}
