package jp.ac.hcs.gondo.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.BaseSelectRepository;

@Repository("SelectUserIdReposotiyImpl")
public class SelectUserIdReposotiyImpl extends BaseSelectRepository {

	@Override
	protected String createSql() {
		String sql = "SELECT * FROM t_task WHERE user_id = :userId";
		return sql;
	}

	@Override
	protected Map<String, Object> createParams(TodoData todoData) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", todoData.getUserId());
		return params;
	}
}
