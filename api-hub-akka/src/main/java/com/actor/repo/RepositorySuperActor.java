package com.actor.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.actor.repo.msg.CompletMakePoolRepository;
import com.actor.repo.msg.RequestMakePoolRepository;
import com.actor.repo.msg.UserPersistanceCommand;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.SmallestMailboxPool;

public class RepositorySuperActor extends AbstractActor {

	private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

	private Optional<ActorRef> router = Optional.empty();

	static Props props() {
		return Props.create(RepositorySuperActor.class, () -> new RepositorySuperActor());
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder()
		.match(RequestMakePoolRepository.class, msg -> {
			this.router = Optional.of(getContext().actorOf(
					new SmallestMailboxPool(msg.getSizeOfPool()).props(Props.create(RepositoryActor.class)), "repo-pool"));
			getSender().tell(new CompletMakePoolRepository(this.router.get().path().toString()), getSelf());
		})
		.match(UserPersistanceCommand.class, msg -> {
			this.router.get().tell(msg, getSender());
		}).build();
	}

}
