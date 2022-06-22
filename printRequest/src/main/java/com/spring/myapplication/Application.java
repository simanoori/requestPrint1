package com.spring.myapplication;

/**
 * Created by Hi on 6/6/2022.
 */

import com.spring.myapplication.aspect.ExecuteTime;
import com.spring.myapplication.repository.jdbc.CardPrintRequestCRUDJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class Application implements ApplicationListener<ApplicationReadyEvent>{
  private  CardPrintRequestCRUDJDBC cardPrintRequestCRUDJDBC ;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @ExecuteTime
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        cardPrintRequestCRUDJDBC.addFakeDateToCardPrintRequests();
    }
}
