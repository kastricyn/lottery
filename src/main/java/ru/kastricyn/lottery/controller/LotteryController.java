package ru.kastricyn.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.exception.LotteryStartException;
import ru.kastricyn.lottery.service.LotteryService;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {
  private final LotteryService lotteryService;

  @Autowired
  public LotteryController(LotteryService lotteryService) {
    this.lotteryService = lotteryService;
  }

  @PostMapping("/participant")
  public void addParticipant(Participant participant) {
    lotteryService.addParticipant(participant);
  }

  @GetMapping("/participant")
  public List<Participant> getAllParticipants() {
    return lotteryService.getAllParticipant();
  }

  @GetMapping("/start")
  public String start() {
    StringBuilder str = new StringBuilder("Смотрите выиграл: ");
    try {
      return str.append(lotteryService.start()).toString();
    } catch (LotteryStartException e) {
      return "Кажется что-то пошло не так: " + e.getMessage();
    }
  }

  @GetMapping("/winners")
  public List<Participant> getAllWinners() {
    return lotteryService.getAllWinners();
  }
}
