package com.app.actor;

import com.actor.repo.msg.UserPersistanceCommand;

import akka.actor.AbstractActor;

public class RepositoryHubActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(UserPersistanceCommand.class, message -> {
					getContext().actorSelection("repo-super-actor").tell(null, getSender());
		}).build();		
	}

}
