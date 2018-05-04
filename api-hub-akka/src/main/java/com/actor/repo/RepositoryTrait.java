package com.actor.repo;

import java.sql.SQLException;

import org.jooq.Record;
import org.jooq.Result;

public interface RepositoryTrait {
	public Result<Record> findAllUser() throws SQLException;
}
