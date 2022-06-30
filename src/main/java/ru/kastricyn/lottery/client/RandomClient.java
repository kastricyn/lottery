package ru.kastricyn.lottery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@FeignClient(
    name = "random",
    url = "${feign.client.random.host}",
    configuration = FeignConfiguration.class)
public interface RandomClient {
  Random random = new Random();

  @GetMapping(
      value = "/integers/",
      consumes = MediaType.TEXT_PLAIN_VALUE)
  ResponseEntity<String> getRandom(@SpringQueryMap QueryParams queryParams);

  default int getRandom(int min, int max) {
//        var queryParams = new QueryParams(1, min, max, 1, 10, "plain", "new");
//        return Integer.valueOf(getRandom(queryParams).getBody());
    return Math.abs(random.nextInt() % (max - min) + min);
  }

  record QueryParams(int num, long min, long max, int col, int base, String format, String rnd) {}
}
