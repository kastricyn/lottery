package ru.kastricyn.lottery.service;

import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.dto.ResultLottery;

import java.util.List;

public interface LotteryService {

    void addParticipant(Participant participant);

    List<Participant> getAllParticipant();

    ResultLottery start();

    List<Participant> getAllWinners();
}
