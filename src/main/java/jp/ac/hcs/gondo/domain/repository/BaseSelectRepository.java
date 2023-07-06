package jp.ac.hcs.gondo.domain.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.entity.Todo;

public abstract class BaseSelectRepository implements SelectRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Override
	public List<Todo> select(TodoData data) {
		List<Map<String, Object>> resultSet = query(data);
		List<Todo> todos = convert(resultSet);
		return todos;
	}

	private List<Map<String, Object>> query(TodoData data) {
		String sql = createSql();
		Map<String, Object> params = createParams(data);
		return jdbc.queryForList(sql, params);
	}

	private List<Todo> convert(List<Map<String, Object>> resultSet) {
		List<Todo> todos = new ArrayList<>();
		for (Map<String, Object> record : resultSet) {
			Todo todo = new Todo();
			todo.setId((int) (record.get("id")));
			todo.setUserId((String) record.get("user_id"));
			todo.setTitle((String) record.get("title"));
			todo.setLimitDay((Date) record.get("limit_day"));
			todo.setComplate((boolean) record.get("complate"));
			todos.add(todo);
		}
		return todos;
	}

	protected abstract String createSql();

	protected abstract Map<String, Object> createParams(TodoData todoData);
}
