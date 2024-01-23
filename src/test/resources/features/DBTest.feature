# language: ru

@all
@DB
Функция: Добавление и удаление данных в БД


  @correct
  Сценарий: Добавление в БД строки и её удаление
    * Добавить строку с ID - 100, названием - "Мандарин", типом - "FRUIT", и экзотичный - 1
    * Проверяется, что строка с ID - 100, названием - "Мандарин", типом - "FRUIT", и экзотичный - 1 добавлена
    * Удалить строку с ID - 100
    * Проверяется, что строка с ID - 100 удалена
