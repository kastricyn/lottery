### Запуск

```
#сборка
./mvnw package
#запускаем
java -jar target/lottery-0.0.1-SNAPSHOT.jar
```

Разрабатывалось и работает на **JDK17** (openjdk 17.0.3; corretto-17.0.3)

### Примеры запросов и ответов: 

---
Добавим участника:
```
POST http://localhost:8080/lottery/participant
Content-Type: application/json

{"name":"Ma16xa","age":-166,"city":"Saint-Petersburg"}
```
---
Получим всех участников:
```
GET http://localhost:8080/lottery/participant
```

```
[
  {
    "name": "Maxima",
    "age": 16,
    "city": "Saint-Petersburg"
  },
  {
    "name": "Maxa",
    "age": 50,
    "city": "Saint-Petersburg"
  },
  {
    "name": "Ma56xa",
    "age": 46,
    "city": "Saint-Petersburg"
  }
]
```
---
Проведём лотерею:
```
GET http://localhost:8080/lottery/start
```
```
Кажется что-то пошло не так: 
Должно быть больше 2 участников, пока только 0 участников.
```
или
```
Смотрите выиграл: ResultLotteryEntity(id=6, name=Ma16xa, age=-166, city=Saint-Petersburg, winValue=392)
```

---
Получим список победителей:
```
GET http://localhost:8080/lottery/winners
```
```
[
  {
    "participant": {
      "name": "Maxima",
      "age": 16,
      "city": "Saint-Petersburg"
    },
    "winValue": 472
  },
  {
    "participant": {
      "name": "Ma16xa",
      "age": -166,
      "city": "Saint-Petersburg"
    },
    "winValue": 392
  }
]
```


