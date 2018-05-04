package com.actor.repo.msg;

import lombok.Value;

@Value
public class CompletMakePoolRepository {
	
	public CompletMakePoolRepository(String path) {
		this.routeUri = path;
	}

	private String routeUri;
}
