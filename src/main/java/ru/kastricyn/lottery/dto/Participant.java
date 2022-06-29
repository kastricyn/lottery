package ru.kastricyn.lottery.dto;

//todo: should check age> 0 || 18 ?
public record Participant(String name, int age, String city) {
}
