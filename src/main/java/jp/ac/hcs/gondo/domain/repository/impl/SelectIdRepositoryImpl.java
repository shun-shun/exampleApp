package jp.ac.hcs.gondo.domain.repository.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import jp.ac.hcs.gondo.domain.dto.TodoData;
import jp.ac.hcs.gondo.domain.repository.FindRepository;

@Repository("SelectUserIdReposotiyImpl")
public class SelectIdRepositoryImpl extends FindRepository {

	@Override
	protected String createSql() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	protected Map<String, Object> createParams(TodoData todoData) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
