package org.activeledger.java.sdk.activeledgerjavasdk;

import org.activeledger.java.sdk.connection.Connection;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ActiveledgerJavaSdkApplication {
	private static AbstractApplicationContext context;

	private ActiveledgerJavaSdkApplication() {
	}

	public static AbstractApplicationContext init() {

		context = new AnnotationConfigApplicationContext(AppConfig.class);

		return context;
	}

	public static void setConnection(String protocol, String url, String port) {

		Connection.setProtocol(protocol);
		Connection.setUrl(url);
		Connection.setPort(port);

	}

	public static AbstractApplicationContext getContext() {
		if (context == null) {
			context = ActiveledgerJavaSdkApplication.init();
		}
		return context;
	}
}
