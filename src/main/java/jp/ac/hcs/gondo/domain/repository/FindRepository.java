package jp.ac.hcs.gondo.domain.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.entity.Todo;

public abstract class FindRepository implements TodoFindRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public Todo find(TodoData data) {
		List<Map<String, Object>> resultSet = query(data);
		Todo todo = convert(resultSet);
		return todo;
	}
	
	private List<Map<String, Object>> query(TodoData data) {
		String sql = createSql();
		Map<String, Object> params = createParams(data);
		return jdbc.queryForList(sql, params);
	}
	
	private Todo convert(List<Map<String, Object>> resultSet) {
		Todo todo = new Todo();
		for(Map<String, Object> record : resultSet) {
			todo.setId((int)(record.get("id")));
			todo.setUserId((String)record.get("user_id"));
			todo.setTitle((String)record.get("title"));
			todo.setLimitDay((Date)record.get("limit_day"));
			todo.setComplate((boolean)record.get("complete"));
		}
		return todo;
	}
	
	protected abstract String createSql();
	
	protected abstract Map<String, Object> createParams(TodoData todoData);
}
