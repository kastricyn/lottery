package ru.kastricyn.lottery.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kastricyn.lottery.entity.ResultLotteryEntity;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface ResultLotteryRepository extends CrudRepository<ResultLotteryEntity, Long> {
    List<ResultLotteryEntity> getAll();
}
