package ru.kastricyn.lottery.mapper;

import org.springframework.stereotype.Service;
import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.entity.ParticipantEntity;

@Service
public class ParticipantMap {
  public ParticipantEntity get(Participant participant) {
    var ans = new ParticipantEntity();
    ans.setName(participant.name());
    ans.setAge(participant.age());
    ans.setCity(participant.city());
    return ans;
  }

  public Participant get(ParticipantEntity participantEntity) {
    return new Participant(
        participantEntity.getName(), participantEntity.getAge(), participantEntity.getCity());
  }
}
