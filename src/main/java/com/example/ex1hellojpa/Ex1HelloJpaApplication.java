package com.example.ex1hellojpa;

import com.example.ex1hellojpa.domain.Book;
import com.example.ex1hellojpa.domain.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class Ex1HelloJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex1HelloJpaApplication.class, args);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Book book = new Book();
            book.setAuthor("김경식");
            book.setName("돈키호테");
            em.persist(book);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

}
