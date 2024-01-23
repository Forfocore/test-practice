# language: ru

@all
@UI
Функция: Добавление в таблицу данных

  Предыстория:
    * открыта страница по адресу "http://149.154.71.152:8080/"

  @correct
  Сценарий: Добавление в таблицу типичных данных
    * выполнено нажатие на кнопку 'Песочница'
    * выполнено нажатие на кнопку 'Товары'
    * выполнено нажатие на кнопку 'Добавить'
    * значение поля 'Имя' заполняется значением "Мандарин", значение поля 'Тип' заполняется значением "FRUIT", значение поля 'Экзотический' заполняется значением "true"
    * выполнено нажатие на кнопку 'Сохранить'
    * результат проверяется со значениями "Мандарин", "Фрукт", "true"

  @correct
  Сценарий: Добавление в таблицу нетипичных данных
    * выполнено нажатие на кнопку 'Песочница'
    * выполнено нажатие на кнопку 'Товары'
    * выполнено нажатие на кнопку 'Добавить'
    * значение поля 'Имя' заполняется значением "123450$&!", значение поля 'Тип' заполняется значением "VEGETABLE", значение поля 'Экзотический' заполняется значением "false"
    * выполнено нажатие на кнопку 'Сохранить'
    * результат проверяется со значениями "123450$&!", "Овощ", "false"