package ru.kastricyn.lottery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${feign.client.random.url}", name = "random")
public interface RandomClient {
  @GetMapping("/integers")
  int getRandom(@SpringQueryMap QueryParams queryParams);

  default int getRandom(int min, int max) {
    var queryParams = new QueryParams(1, min, max, 1, 10, "plain", "new");
    return getRandom(queryParams);
  }

  record QueryParams(int num, long min, long max, int col, int base, String format, String rnd) {}
}
