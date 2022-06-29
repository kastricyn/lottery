package ru.kastricyn.lottery.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kastricyn.lottery.dto.ResultLottery;
import ru.kastricyn.lottery.entity.ResultLotteryEntity;
@Service
public class ResultLotteryMap {
    final private ParticipantMap participantMap;

    @Autowired
    public ResultLotteryMap(ParticipantMap participantMap) {
        this.participantMap = participantMap;
    }

    public ResultLotteryEntity get(ResultLottery resultLottery) {
        var ans = new ResultLotteryEntity();
        ans.setParticipant(participantMap.get(resultLottery.participant()));
        ans.setWinValue(resultLottery.winValue());
        return ans;
    }

    public ResultLottery get(ResultLotteryEntity resultLotteryEntity) {
        return new ResultLottery(participantMap.get(resultLotteryEntity.getParticipant()),
                resultLotteryEntity.getWinValue());
    }
}
