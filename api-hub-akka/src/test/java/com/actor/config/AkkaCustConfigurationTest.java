package com.actor.config;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

@RunWith(JUnitPlatform.class)
public class AkkaCustConfigurationTest {

	@Test
	public void test_config() {
		try {
			Config conf = ConfigFactory.load("application.conf");
			System.out.println(conf.getString("jooq.url")); 			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
