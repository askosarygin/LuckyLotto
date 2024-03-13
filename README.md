## Описание
Игра в слот машину из казино, в случае успеха начисляются очки, в случае неудачи списываются очки. Можно посмотреть историю выигрышей и проигрышей.

## О проекте
Данные хранятся локально.
Архитектура проекта старается следовать принципам Clean architecture, и делится на модули:

* app - модуль, который знает обо всех модулях в проекте и выступает местом для хранения всех зависимостей (в классе MainApp)
* common - модуль для хранения общей на проект информации: расширений классов, сущностей для обмена данными между слоями ui, domain, data, настроек темы, и ресурсов
* data - модуль для работы с внутренней БД
* *-ui - модули для хранений экранов и вью моделей для них
* *-domain - модули для выполнения бизнес логики и подтягивания данных из слоя data в слой ui

## Скриншоты

<img src="https://github.com/askosarygin/LuckyLotto/assets/77168356/0034d6b4-e8c0-4107-b3f4-1ad5ca24bcc0" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/LuckyLotto/assets/77168356/46edb724-89a7-4aac-b397-e68d5f850f64" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/LuckyLotto/assets/77168356/4c217e75-5b5f-4a62-982f-b4ae98fadbcb" alt="drawing" width="200"/>
<img src="https://github.com/askosarygin/LuckyLotto/assets/77168356/6708e6db-8c9d-4940-b482-8acc0a170e26" alt="drawing" width="200"/>
