package ru.kastricyn.lottery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.kastricyn.lottery.dto.Participant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ResultLottery")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResultLotteryEntity {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique = true, nullable = false)
  private Long id;

  private String name;
  private int age;
  private String city;

  private int winValue;

  public ResultLotteryEntity(ParticipantEntity participantEntity) {
    name = participantEntity.getName();
    age = participantEntity.getAge();
    city = participantEntity.getCity();
  }

  public ResultLotteryEntity(ParticipantEntity participantEntity, int winValue) {
    this(participantEntity);
    this.winValue = winValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ResultLotteryEntity that = (ResultLotteryEntity) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
