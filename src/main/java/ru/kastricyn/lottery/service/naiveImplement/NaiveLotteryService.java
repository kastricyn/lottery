package ru.kastricyn.lottery.service.naiveImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kastricyn.lottery.client.RandomClient;
import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.entity.ParticipantEntity;
import ru.kastricyn.lottery.entity.ResultLotteryEntity;
import ru.kastricyn.lottery.exception.LotteryStartException;
import ru.kastricyn.lottery.mapper.ParticipantMap;
import ru.kastricyn.lottery.mapper.ResultLotteryMap;
import ru.kastricyn.lottery.repository.ParticipantRepository;
import ru.kastricyn.lottery.repository.ResultLotteryRepository;
import ru.kastricyn.lottery.service.LotteryService;

import java.util.List;

@Service
public class NaiveLotteryService implements LotteryService {
  private final ParticipantRepository participantRepository;
  private final ResultLotteryRepository resultLotteryRepository;
  private final ParticipantMap participantMap;
  private final ResultLotteryMap resultLotteryMap;

  private final RandomClient randomClient;

  @Autowired
  public NaiveLotteryService(
      ParticipantRepository participantRepository,
      ResultLotteryRepository resultLotteryRepository,
      ParticipantMap participantMap,
      ResultLotteryMap resultLotteryMap,
      RandomClient randomClient) {
    this.participantRepository = participantRepository;
    this.resultLotteryRepository = resultLotteryRepository;
    this.participantMap = participantMap;
    this.resultLotteryMap = resultLotteryMap;
    this.randomClient = randomClient;
  }

  @Override
  public ParticipantEntity addParticipant(Participant participant) {
    ParticipantEntity ans = participantMap.get(participant);
    participantRepository.save(ans);
    return ans;
  }

  @Override
  public List<ParticipantEntity> getAllParticipantEntity() {
    return participantRepository.findAll();
  }

  @Override
  @Transactional
  public ResultLotteryEntity start() throws LotteryStartException {
    var participants = getAllParticipantEntity();
    if (participants.size() < 2)
      throw new LotteryStartException(
          "Должно быть больше 2 участников, пока только " + participants.size() + " участников.");

    int winValue =
        randomClient.getRandom(1, 1000); // todo: вынести в параметры application.property
    int idx =
        randomClient.getRandom(0, participants.size() - 1); // подумать что тут может быть не так
    var ans = new ResultLotteryEntity(participants.get(idx));
    ans.setWinValue(winValue);
    resultLotteryRepository.save(ans);
    participantRepository.deleteAll();
    return ans;
  }

  @Override
  public List<ResultLotteryEntity> getAllWinners() {
    return resultLotteryRepository.findAll();
  }
}
