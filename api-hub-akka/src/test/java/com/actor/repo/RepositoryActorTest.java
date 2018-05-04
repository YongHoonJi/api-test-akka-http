package com.actor.repo;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.actor.repo.msg.UserPersistanceCommand;
import com.jooq.test.domain.Tables;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;

@RunWith(JUnitPlatform.class)
public class RepositoryActorTest {

	static ActorSystem system;

	@BeforeAll
	public static void beforeAll() {
		system = ActorSystem.create();
		System.out.println("create an actor system.");
	}

	@AfterAll
	public static void afterAll() {
		TestKit.shutdownActorSystem(system);
		System.out.println("shutdown an actor system.");
		system = null;
	}

	@Test
	public void findAllUser() {
		Result<Record3<Integer, String, String>> record = mock();
		new TestKit(system) {
			{
				final ActorRef testActor = system.actorOf(Props.create(RepositoryActor.class), "testActor01");
				testActor.tell(new UserPersistanceCommand(), getRef());
				expectMsg(java.time.Duration.ofSeconds(3), record);
			}
		};
	}

	private Result<Record3<Integer, String, String>> mock() {
		DSLContext create = DSL.using(SQLDialect.MYSQL);
		Result<Record3<Integer, String, String>>  record = create.newResult(Tables.USER.USER_ID, Tables.USER.ACCOUNT,Tables.USER.NAME);
		record.add(create.newRecord(Tables.USER.USER_ID, Tables.USER.ACCOUNT,Tables.USER.NAME)
				.values(1, "account", "name"));
		return record;
	}
	
}
