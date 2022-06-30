package ru.kastricyn.lottery.service;

import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.dto.ResultLottery;
import ru.kastricyn.lottery.entity.ParticipantEntity;
import ru.kastricyn.lottery.entity.ResultLotteryEntity;
import ru.kastricyn.lottery.exception.LotteryStartException;

import java.util.List;

public interface LotteryService {

  ParticipantEntity addParticipant(Participant participant);

  List<ParticipantEntity> getAllParticipantEntity();

  ResultLotteryEntity start() throws LotteryStartException;

  List<ResultLotteryEntity> getAllWinners();
}
