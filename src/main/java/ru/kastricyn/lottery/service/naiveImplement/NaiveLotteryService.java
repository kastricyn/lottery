package ru.kastricyn.lottery.service.naiveImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kastricyn.lottery.client.RandomClient;
import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.dto.ResultLottery;
import ru.kastricyn.lottery.exception.LotteryStartException;
import ru.kastricyn.lottery.mapper.ParticipantMap;
import ru.kastricyn.lottery.repository.ParticipantRepository;
import ru.kastricyn.lottery.repository.ResultLotteryRepository;
import ru.kastricyn.lottery.service.LotteryService;

import java.util.List;

@Service
public class NaiveLotteryService implements LotteryService {
  private final ParticipantRepository participantRepository;
  private final ResultLotteryRepository resultLotteryRepository;
  private final ParticipantMap participantMap;
  private final RandomClient randomClient;

  @Autowired
  public NaiveLotteryService(
      ParticipantRepository participantRepository,
      ResultLotteryRepository resultLotteryRepository,
      ParticipantMap participantMap,
      RandomClient randomClient) {
    this.participantRepository = participantRepository;
    this.resultLotteryRepository = resultLotteryRepository;
    this.participantMap = participantMap;
    this.randomClient = randomClient;
  }

  @Override
  public void addParticipant(Participant participant) {
    participantRepository.save(participantMap.get(participant));
  }

  @Override
  public List<Participant> getAllParticipant() {
    return participantRepository.getAll();
  }

  @Override
  // todo: это всё обернуть внутрь одной транзакции
  public ResultLottery start() throws LotteryStartException {
    long count = participantRepository.count();
    if (count < 2)
      throw new LotteryStartException(
          "Должно быть больше 2 участников, пока только " + count + " участников.");

    int winValue =
        randomClient.getRandom(1, 1000); // todo: вынести в параметры application.property
    int idx = randomClient.getRandom(0, (int) count - 1); // подумать что тут может быть не так
    var participants = participantRepository.getAll();
    return new ResultLottery(participants.get(idx), winValue);
  }

  @Override
  public List<Participant> getAllWinners() {
    return resultLotteryRepository.getAll().stream()
        .map(resultLotteryEntity -> participantMap.get(resultLotteryEntity.getParticipant()))
        .toList();
  }
}
