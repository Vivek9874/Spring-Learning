package com.learning.springdatajpa;
import com.learning.springdatajpa.repository.WomanRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.learning.springdatajpa.model.Woman;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		System.out.println("Hello");
		//object of woman class
		
		WomanRepository repo = context.getBean(WomanRepository.class);
		
		Woman woman1 = context.getBean(Woman.class);
		Woman woman2 = context.getBean(Woman.class);
		Woman woman3 = context.getBean(Woman.class);
        Woman woman4 = context.getBean(Woman.class);
        Woman woman5 = context.getBean(Woman.class);
		
		woman1.setId(01);
		woman1.setName("Leena");
		woman1.setAge(45);
		woman1.setSize("34C");
//		
		woman2.setId(02);
		woman2.setName("Mrunal");
		woman2.setAge(23);
		woman2.setSize("32D");
		
		woman3.setId(03);
		woman3.setName("Priya");
        woman3.setAge(30);
        woman3.setSize("36B");

        woman4.setId(04);
        woman4.setName("Sonia");
        woman4.setAge(28);
        woman4.setSize("34B");

        woman5.setId(05);
        woman5.setName("Aisha");
        woman5.setAge(35);
        woman5.setSize("38C");
//		
		System.out.println(repo.save(woman1));
		System.out.println(repo.save(woman2));
		System.out.println(repo.save(woman3));
		System.out.println(repo.save(woman4));
		System.out.println(repo.save(woman5));

		
//		System.out.println(repo.findById(1));
		
//		System.out.println(repo.findByName("Leena"));
		System.out.println(repo.findBySize("34C"));
		
//		System.out.println(repo.findByName("Aisha"));
////		System.out.println(repo.findBySize("34B"));
//		System.out.println(repo.save(woman2));
//		repo.delete(woman3);
		
	}

}
