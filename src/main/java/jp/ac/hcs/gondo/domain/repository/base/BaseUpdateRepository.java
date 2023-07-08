package jp.ac.hcs.gondo.domain.repository.base;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.ac.hcs.gondo.domain.dto.StatusCode;
import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.UpdateRepository;

public abstract class BaseUpdateRepository implements UpdateRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public StatusCode update(TodoData data) {
		int updateRows = query(data);
		StatusCode statusCode = convert(updateRows);
		return statusCode;
	}
	
	private int query(TodoData data) {
		String sql = createSql();
		Map<String, Object> params = createParams(data);
		return jdbc.update(sql, params);
	}

	private StatusCode convert(int updateRows) {
		switch (updateRows) {
		case 1:
			return StatusCode.OK;
		default:
			return StatusCode.NG;
		}
	}

	protected abstract String createSql();

	protected abstract Map<String, Object> createParams(TodoData todoData);

}
