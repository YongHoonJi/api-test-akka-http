package com.slick.test;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import akka.Done;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.alpakka.slick.javadsl.Slick;
import akka.stream.alpakka.slick.javadsl.SlickRow;
import akka.stream.alpakka.slick.javadsl.SlickSession;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

@RunWith(JUnitPlatform.class)
public class DbmsTest {

	private static final SlickSession session = SlickSession.forConfig("slick-mysql");
	
	public void testConnection() {
		ActorSystem system = ActorSystem.create();
		ActorMaterializer materializer = ActorMaterializer.create(system);		
		// close databse connection pool
		system.registerOnTermination(session::close);
		
		// test plain query
		System.out.println("plain query");
		CompletionStage<Done> done = this.plainQuery("SELECT ID, NAME FROM ALPAKKA_SLICK_JAVADSL_TEST_USERS", materializer);
		System.out.println(done);
		// shutdown actor system
		system.terminate();
	}
	
	private CompletionStage<Done> plainQuery(String query, ActorMaterializer materializer) {
		final CompletionStage<Done> done =
			      Slick
			        .source(
			          session,
			          query,
			          (SlickRow row) -> new User(row.nextInt(), row.nextString())
			        )
			        .runWith(Sink.ignore(), materializer);

			    done.whenComplete((value, exception) -> {
			    	System.out.println(exception);
			    	System.out.println("complete query");
			    });
			    
			    return done;
	}
	
	public void test_raw() {
		    final ActorSystem system = ActorSystem.create();
		    final Materializer materializer = ActorMaterializer.create(system);

		    final SlickSession session = SlickSession.forConfig("slick-mysql");
		    final CompletionStage<Done> done =
		      Slick
		        .source(
		          session,
		          "SELECT ID, NAME FROM ALPAKKA_SLICK_JAVADSL_TEST_USERS",
		          (SlickRow row) -> new User(row.nextInt(), row.nextString())
		        )
		        .runWith(Sink.ignore(), materializer);

		    done.whenComplete((value, exception) -> {
		    	System.out.println(value);
		    	System.out.println(exception);
		      session.close();
		      system.terminate();
		    });
		    
		    System.out.println(done);
	}
	
	@Test
	public void sink() {
		final ActorSystem system = ActorSystem.create();
	    final Materializer materializer = ActorMaterializer.create(system);

	    final SlickSession session = SlickSession.forConfig("slick-mysql");

	    final List<User> users = IntStream.range(0, 42).boxed().map((i) -> new User(i, "Name"+i)).collect(Collectors.toList());
	    System.out.println(users.size());
	    final CompletionStage<Done> done =
	      Source
	        .from(users)
	        .runWith(
	          Slick.<User>sink(
	            session,
	            // add an optional second argument to specify the parallism factor (int)
	            (user) -> "INSERT INTO ALPAKKA_SLICK_JAVADSL_TEST_USERS VALUES (" + user.getId() + ", '" + user.getName() + "')"
	          ),
	          materializer
	        );

	    done.whenComplete((value, exception) -> {
	      session.close();
	      system.terminate();
	    });
	  }		

}
