package com.jooq.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static com.jooq.test.domain.tables.User.USER;

@RunWith(JUnitPlatform.class)
public class JooqTest {
	@Test
	public void testConnection() {
		String userName = "local";
        String password = "local";
        String url = "jdbc:mysql://localhost:3306/test_temp";
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
        	DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
        	Result<Record> result = create.select().from(USER).fetch();
        	System.out.println(result.toString());
        } 
        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}
