package ru.kastricyn.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.dto.ResultLottery;
import ru.kastricyn.lottery.exception.LotteryStartException;
import ru.kastricyn.lottery.mapper.ParticipantMap;
import ru.kastricyn.lottery.mapper.ResultLotteryMap;
import ru.kastricyn.lottery.service.LotteryService;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {
  private final LotteryService lotteryService;
  private final ParticipantMap participantMap;
  private final ResultLotteryMap resultLotteryMap;


  @Autowired
  public LotteryController(LotteryService lotteryService, ParticipantMap participantMap, ResultLotteryMap resultLotteryMap) {
    this.lotteryService = lotteryService;
    this.participantMap = participantMap;
    this.resultLotteryMap = resultLotteryMap;
  }

  @PostMapping(value = "/participant", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addParticipant(@RequestBody Participant participant) {
    lotteryService.addParticipant(participant);
  }

  @PostMapping("/add")
  public void addParticipant() {
    lotteryService.addParticipant(new Participant("Maxima", 16, "Saint-Petersburg"));
  }

  @GetMapping("/participant")
  public List<Participant> getAllParticipants() {
    return lotteryService.getAllParticipantEntity().stream()
            .map(participantMap::get).toList();
  }

  @GetMapping("/start")
  public String start() {
    StringBuilder str = new StringBuilder("Смотрите выиграл: ");
    try {
      return str.append(lotteryService.start()).toString();
    } catch (LotteryStartException e) {
      return "Кажется что-то пошло не так: \n" + e.getMessage();
    }
  }

  @GetMapping("/winners")
  public List<ResultLottery> getAllWinners() {
    return lotteryService.getAllWinners().stream()
            .map(resultLotteryMap::get)
            .toList();
  }
}
