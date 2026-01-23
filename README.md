Проект автоматизированного тестирования веб-приложения SauceDemo с использованием Selenium, TestNG и Allure.

Предварительные требования

Java Development Kit (JDK) 11 или выше
- Скачать с Oracle или OpenJDK
- Проверить установку: java -version

Apache Maven 3.6 или выше
- Скачать с официального сайта
- Проверить установку: mvn -v

Git (для клонирования репозитория)
- Скачать с git-scm.com

Установка и запуск
- Клонируйте репозиторий:

bash
git clone https://github.com/MrDmitryQA/git-SwagLabs.git

cd git-SwagLabs

- Соберите проект:
bash
mvn clean compile

- Запуск тестов Из IDE IntelliJ IDEA:

Откройте проект по адресу \IdeaProjects\ForResume2\src\test\java\com\example\test
Правой кнопкой на тестовый класс и запустите через контекстное меню

Возможная ошибка при запуске Allure отчета (На компьютере не установлена Java Development Kit (JDK) версии 11 или выше)
Error: Could not find or load main class
[ERROR] Failed to execute goal io.qameta.allure:allure-maven:2.12.0:serve
Решение: Установите JDK: Скачать JDK 11+ https://www.oracle.com/java/technologies/downloads/#java11  
Все необходимые зависимости уже включены в проект (pom.xml)
