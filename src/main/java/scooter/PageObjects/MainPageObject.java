package scooter.PageObjects;

import org.openqa.selenium.By;

public class MainPageObject {
    //логотип Яндекс
    private final By yandexLogo = By.cssSelector("[alt = 'Yandex']");
    //логотип Самокат
    private final By scooter = By.cssSelector("[alt = 'Scooter']");
    //верхняя кнопка Заказать
    private final By orderButtonTop = By.xpath("//*[contains(@class, 'Header')]//button[text()='Заказать']");
    //статус заказа
    private final By orderStatus = By.className("Header_Link__1TAG7");
    //нижняя кнопка Заказать
    private final By orderButtonBottom = By.xpath("//*[contains(@class, 'Button')]//button[text()='Заказать']");
    //Сколько это стоит? И как оплатить?
    private final By howMuchAndHowToPay = By.id("accordion__heading-8");
    //Хочу сразу несколько самокатов! Так можно?
    private final By severalScooters = By.id("accordion__heading-9");
    //Как рассчитывается время аренды?
    private final By timeOfRent = By.id("accordion__heading-10");
    //Можно ли заказать самокат прямо на сегодня?
    private final By todayOrder = By.id("accordion__heading-11");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private final By orderExtend = By.id("accordion__heading-12");
    //Вы привозите зарядку вместе с самокатом?
    private final By scooterCharge = By.id("accordion__heading-13");
    //Можно ли отменить заказ?
    private final By orderCancel = By.id("accordion__heading-14");
    //Я живу за МКАДом, привезёте?
    private final By outOfMoscowOrder = By.id("accordion__heading-15");

}
