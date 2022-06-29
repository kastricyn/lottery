package ru.kastricyn.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableFeignClients
public class LotteryApplication {

  public static void main(String[] args) {
    SpringApplication.run(LotteryApplication.class, args);
  }
}
