package ru.kastricyn.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kastricyn.lottery.entity.ResultLotteryEntity;

public interface ResultLotteryRepository extends JpaRepository<ResultLotteryEntity, Long> {}
