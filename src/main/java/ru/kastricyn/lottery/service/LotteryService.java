package ru.kastricyn.lottery.service;

import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.dto.ResultLottery;
import ru.kastricyn.lottery.exception.LotteryStartException;

import java.util.List;

public interface LotteryService {

  void addParticipant(Participant participant);

  List<Participant> getAllParticipant();

  ResultLottery start() throws LotteryStartException;

  List<Participant> getAllWinners();
}
