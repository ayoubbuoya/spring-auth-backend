package com.buoya.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().filename(".env.local").load();

		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASS", dotenv.get("DB_PASS"));
		System.setProperty("HEDERA_OPERATOR_ACCOUNT_ID", dotenv.get("HEDERA_OPERATOR_ACCOUNT_ID"));
		System.setProperty("HEDERA_OPERATOR_PRIVATE_KEY", dotenv.get("HEDERA_OPERATOR_PRIVATE_KEY"));
		System.setProperty("HEDERA_NETWORK", dotenv.get("HEDERA_NETWORK"));

		SpringApplication.run(CrudApplication.class, args);
	}

}
