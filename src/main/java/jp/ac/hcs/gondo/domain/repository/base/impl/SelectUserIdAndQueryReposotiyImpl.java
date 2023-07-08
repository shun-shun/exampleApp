package jp.ac.hcs.gondo.domain.repository.base.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.base.BaseSelectRepository;

@Repository("SelectUserIdReposotiyImpl")
public class SelectUserIdAndQueryReposotiyImpl extends BaseSelectRepository {

	private static final String LIKE = "%";
	
	@Override
	protected String createSql() {
		String sql = "SELECT * FROM t_task WHERE user_id = :userId AND title LIKE :query";
		return sql;
	}

	@Override
	protected Map<String, Object> createParams(TodoData todoData) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", todoData.getUserId());
		params.put("query", LIKE + todoData.getQuery() + LIKE);
		return params;
	}
}
