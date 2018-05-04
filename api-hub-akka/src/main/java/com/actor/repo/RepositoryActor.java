package com.actor.repo;

import static com.jooq.test.domain.tables.User.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.actor.config.AkkaCustConfiguration;
import com.actor.repo.msg.UserPersistanceCommand;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class RepositoryActor extends AbstractActor implements RepositoryTrait {

	private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	
	private String url;
	private String user;
	private String password;
	
	public RepositoryActor() {
		url = AkkaCustConfiguration.getByName("jooq.url");
		user = AkkaCustConfiguration.getByName("jooq.user");
		password = AkkaCustConfiguration.getByName("jooq.pass");
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}	
	
	@Override
	public Receive createReceive() {
		return receiveBuilder()
			.match(
				UserPersistanceCommand.class, msg -> {
					getSender().tell(findAllUser(), getSelf());
				}
			).build();
	}

	@Override
	public Result<Record> findAllUser() throws SQLException {
		try (Connection conn = this.getConnection()){
			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
			System.out.println(create.select().from(USER).fetch().toString());
        	return create.select().from(USER).fetch();
		} catch (SQLException e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw e;
		}
	}
	
	@Override
	public void preStart() {
		System.out.println("!!!start");
	}
	
	@Override
	public void postStop() {
		System.out.println("!!!stop");
	}

}
