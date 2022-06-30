package ru.kastricyn.lottery.mapper;

import org.springframework.stereotype.Service;
import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.dto.ResultLottery;
import ru.kastricyn.lottery.entity.ResultLotteryEntity;

@Service
public class ResultLotteryMap {

  public ResultLotteryEntity get(ResultLottery resultLottery) {
    var ans = new ResultLotteryEntity();
    ans.setName(resultLottery.participant().name());
    ans.setAge(resultLottery.participant().age());
    ans.setCity(resultLottery.participant().city());
    ans.setWinValue(resultLottery.winValue());
    return ans;
  }

  public ResultLottery get(ResultLotteryEntity resultLotteryEntity) {
    return new ResultLottery(
        new Participant(
            resultLotteryEntity.getName(),
            resultLotteryEntity.getAge(),
            resultLotteryEntity.getCity()),
        resultLotteryEntity.getWinValue());
  }
}
