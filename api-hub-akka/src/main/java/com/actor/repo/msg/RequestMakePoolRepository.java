package com.actor.repo.msg;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RequestMakePoolRepository {
	private int sizeOfPool;
}
