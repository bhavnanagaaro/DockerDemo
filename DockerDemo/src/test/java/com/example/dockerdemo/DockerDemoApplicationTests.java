package com.example.dockerdemo;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DockerDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	DataSource dataSource;

	@Test
	@PostConstruct
	public void testConnection() {
		try (Connection conn = dataSource.getConnection()) {
			System.out.println("Connected to the database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
