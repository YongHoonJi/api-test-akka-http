package com.actor.repo;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.actor.repo.msg.CompletMakePoolRepository;
import com.actor.repo.msg.RequestMakePoolRepository;
import com.actor.repo.msg.UserPersistanceCommand;
import com.jooq.test.domain.Tables;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.javadsl.TestKit;

@RunWith(JUnitPlatform.class)
public class RepositorySuperActorTest {
	
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
	}	
	
	@Test
	@Disabled
	public void createPoolTest() {
		new TestKit(system) {
			{
				final ActorRef testActor = system.actorOf(Props.create(RepositorySuperActor.class), "repo-super-actor");
				testActor.tell(RequestMakePoolRepository.builder().sizeOfPool(3).build(), getRef());
				expectMsg(java.time.Duration.ofSeconds(30), new CompletMakePoolRepository("akka://default/user/repo-super-actor/repo-pool"));
			}
		};
	}
	
	@Test
	@Disabled
	public void poolingTest() { 
		new TestKit(system) {
			{
				final ActorRef testActor = system.actorOf(Props.create(RepositorySuperActor.class), "repo-super-actor");
				// make pool
				testActor.tell(RequestMakePoolRepository.builder().sizeOfPool(3).build(), getRef());
				// request persistence
				testActor.tell(new UserPersistanceCommand(), getRef());
				testActor.tell(new UserPersistanceCommand(), getRef());
				testActor.tell(new UserPersistanceCommand(), getRef());
				testActor.tell(new UserPersistanceCommand(), getRef());
				// wait 10seconds
				try {
					Thread.sleep(10000);
				} catch (Exception e) {
				}
			}
		};
	}	
	
	@Test
	public void findMockUserTest() {
		Result<Record3<Integer, String, String>> record = mock();
		final ActorRef testActor = system.actorOf(Props.create(RepositorySuperActor.class), "repo-super-actor");
		testActor.tell(RequestMakePoolRepository.builder().sizeOfPool(1).build(), null);
		new TestKit(system) {
			{
				testActor.tell(new UserPersistanceCommand(), getRef());
				expectMsg(java.time.Duration.ofSeconds(3), record);
			}
		};
	}

	// make mock
	private Result<Record3<Integer, String, String>> mock() {
		DSLContext create = DSL.using(SQLDialect.MYSQL);
		Result<Record3<Integer, String, String>>  record = create.newResult(Tables.USER.USER_ID, Tables.USER.ACCOUNT,Tables.USER.NAME);
		record.add(create.newRecord(Tables.USER.USER_ID, Tables.USER.ACCOUNT,Tables.USER.NAME)
				.values(1, "account", "name"));
		return record;
	}
}
