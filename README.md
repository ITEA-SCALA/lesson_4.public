# Scala AutoMapper

* https://github.com/bfil/scala-automapper


# DI in Scala: guide: 'Cake pattern', 'MacWire'

* `Tutorial` https://di-in-scala.github.io/
* `Repo` https://github.com/softwaremill/macwire


---

## CodersBistro

* `Repo` https://github.com/CodersBistro/akka-http-REST-application

1. В качестве базы данных, реализуем собственный псевдо-репозиторий в `com.itea.codersbistro.repository.EmployeeRepository`
2. Здесь составной тип данных `com.itea.codersbistro.entity.Employee`, который включат в себя `com.itea.codersbistro.entity.Address`
3. В качестве конвертора (Мапера) из Entity в DTO применяется `Spray JSON для JSON marshalling / un-marshalling`
4. Здесь применяется REST API, реализованный через Akka HTTP `com.itea.codersbistro.controller.EmployeeController`
   * `GET` http://localhost:8080/api/employee/100
     ```json
     {
       "active": true,
       "address": {
         "city": "Torronto",
         "id": 0,
         "line1": "2234",
         "line2": "Cambridge Street",
         "state": "Torronto",
         "zipCode": "2414132"
       },
       "firstName": "Lala",
       "id": 100,
       "lastName": "Lee"
     }
     ```

По хорошему должно быть так:
- В базе хранятся сущности в виде отдельных таблиц и на уровне слоя-репозитория приложения можно реализовать раздельные методы для разных сущностей.
- Но на уровне слоя-сервиса приложения все эти сущности объединяются в один объект со сложной структурой.
  - Конвертор из Entity в DTO (и обратно) [Monocle](https://www.baeldung.com/scala/monocle-optics) чтобы правильно создавать копии конвертированных объектов...
- На уровне слоя-контролера приложения должна применяется сущность типа `HttpEntity`, формат которой состоит из: тип содержимого, статус ответа, и тело ответа;  
  - при этом тело ответа должно быть сконвертировано в форму JSON-а (причем нулевые/пустые поля структуры передаваться не должны, и форма полей должен быть форматированный)
- А также нужно предвидеть вариант с плохим ответом на (верхнем) уровне слоя-контролера приложения...


Для конвертации объекта класса в JSON в Scala могут применятся:
- библиотека [Scala AutoMapper](https://github.com/bfil/scala-automapper), но эта библиотека уже не пользуется такой популярностью
- библиотека [Chimney](https://scalalandio.github.io/chimney), вот эта библиотека является самая актуальная на сегодняшний день
  - **(** [lesson_5.public](https://github.com/ITEA-SCALA/lesson_5.public) >> [Ссылка на запись 5 занятия](https://us02web.zoom.us/rec/play/oS7ehfZyG5b1FYsrZkttX16_nHe5K6orqBTv4vZnsKogkxoSlq35M3HzXjlXH42oYEgxxD67yPWe4Qlt.hlub4EoYPi7IfMpa?continueMode=true&_x_zm_rtaid=SuiIm9yZTz6W64UCsOHJaw.1635159563087.237baa5a4b74da8798e185ebfcfd2ba4&_x_zm_rhtaid=522) **)**

Ссылка на пример:
- `REST API` на базе `Akka HTTP` https://github.com/ITEA-SCALA/akka-http-rest-example
- `REST API` с `Akka Actor` https://github.com/ITEA-SCALA/akka-http-REST

---

[Zoom * Ссылка на запись 4 занятия](https://us02web.zoom.us/rec/play/ef9bblHtV4JpV2QdEyAdsUrFk91oEIAtt9_iqT8gdD2eFAq0su7jZxuyo3RRnQlDPmz0ClsxU4w4ijDY.m3kqOZ1oEHar6yJ7?continueMode=true&_x_zm_rtaid=fU30Sl53Q7aSgbFjdd5gZQ.1633530332861.7d6e92a77de49932e53a113ad642839d&_x_zm_rhtaid=829)