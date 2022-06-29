package ru.kastricyn.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LotteryApplication {

  public static void main(String[] args) {
    SpringApplication.run(LotteryApplication.class, args);
  }
}
