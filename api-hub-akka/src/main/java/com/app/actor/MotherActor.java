package com.app.actor;

import com.actor.repo.RepositorySuperActor;
import com.actor.repo.msg.RequestMakePoolRepository;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MotherActor extends AbstractActor{
		private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
		ActorRef repoSuperActor;
		public MotherActor() {
			repoSuperActor = getContext().getSystem().actorOf(Props.create(RepositorySuperActor.class), "repo-super-actor");
			log.info("Initializing Actor...");
		}

		@Override
		public Receive createReceive() {
			return receiveBuilder()
					.match(InitializeActorMsg.class, message -> {
						repoSuperActor.tell(RequestMakePoolRepository.builder().sizeOfPool(3).build(), getSelf());
			}).build();
		}
}
