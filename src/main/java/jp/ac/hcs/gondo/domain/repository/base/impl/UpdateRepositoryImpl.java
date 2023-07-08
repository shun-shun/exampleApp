package jp.ac.hcs.gondo.domain.repository.base.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.base.BaseUpdateRepository;

@Repository("UpdateRepositoryImpl")
public class UpdateRepositoryImpl extends BaseUpdateRepository {

	@Override
	protected String createSql() {
		String sql = "UPDATE t_task SET complete = true WHERE id = :id";
		return sql;
	}

	@Override
	protected Map<String, Object> createParams(TodoData todoData) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", todoData.getId());
		return params;
	}

}
