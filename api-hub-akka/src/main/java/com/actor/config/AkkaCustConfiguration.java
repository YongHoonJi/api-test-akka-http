package com.actor.config;


import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * akka의 설정파일(application.conf) 중 사용자 설정 값을 가져옴
 * -Dconfig.resource=/dev.conf 와 같이 환경별 설정 파일를 로드하는 설정이 가능.
 */
public class AkkaCustConfiguration {
	
	private static Config conf = ConfigFactory.load();
	
	static{
		if(conf == null)
			conf = ConfigFactory.load();
	}
	
	public static String getByName(String prop){
		return conf.getString(prop);
	}
	
}