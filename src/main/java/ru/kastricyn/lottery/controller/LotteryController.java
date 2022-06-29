package ru.kastricyn.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.dto.ResultLottery;
import ru.kastricyn.lottery.service.LotteryService;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {
  final private LotteryService lotteryService;

  @Autowired
  public LotteryController(LotteryService lotteryService) {
    this.lotteryService = lotteryService;
  }

  @PostMapping("/participant")
  void addParticipant(Participant participant) {
    lotteryService.addParticipant(participant);
  }

  @GetMapping("/participant")
  List<Participant> getAllParticipants() {
    return lotteryService.getAllParticipant();
  }

  @GetMapping("/start")
  ResultLottery start() {
    return lotteryService.start();
  }

  @GetMapping("/winners")
  List<Participant> getAllWinners() {
    return lotteryService.getAllWinners();
  }
}
