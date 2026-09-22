package menudriven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
	
	@Bean
	public EntityManager getEM() {
		return Persistence.createEntityManagerFactory("dbInfo").createEntityManager();
	}
	
	@Bean
	public EntityTransaction getET() {
		return getEM().getTransaction();
	}
	
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	@Scope("prototype")
	public List<Dish> getDishList() {
		return new ArrayList<Dish>();
	}

	@Bean
	@Scope("prototype")
	public List<Restaurant> getResList() {
		return new ArrayList<Restaurant>();
	}
}
