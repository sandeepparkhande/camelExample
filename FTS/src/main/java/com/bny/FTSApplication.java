package com.bny;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bny.domain.User;

@SpringBootApplication
public class FTSApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(FTSApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
