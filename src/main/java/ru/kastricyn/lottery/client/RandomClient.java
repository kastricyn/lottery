package ru.kastricyn.lottery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${feign.client.random.url}", name = "random")
public interface RandomClient {
    @GetMapping("/integers")
    int getRandom(@SpringQueryMap QueryParams queryParams);

    record QueryParams(int num, int min, int max, int col, int base, String format, String rnd) {
    }
}
