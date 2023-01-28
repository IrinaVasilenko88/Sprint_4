package scooter.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FAQPageObject {
    private WebDriver driver;

    //Сколько это стоит? И как оплатить?
    private final By howMuchAndHowToPay = By.xpath(".//*[contains(text(),'Сколько это стоит? И как оплатить?')]");
    //ответ на первый вопрос
    private final By firstQuestionAnswer = By.xpath(".//*[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или картой.')]");
    //Хочу сразу несколько самокатов! Так можно?
    private final By severalScooters = By.xpath(".//*[contains(text(),'Хочу сразу несколько самокатов! Так можно?')]");
    //ответ на второй вопрос
    private final By secondQuestionAnswer = By.xpath(".//*[contains(text(),'ХПока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.')]");
    //Как рассчитывается время аренды?
    private final By timeOfRent = By.xpath(".//*[contains(text(),'Как рассчитывается время аренды?')]");
    //ответ на третий вопрос
    private final By thirdQuestionAnswer = By.xpath(".//*[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.')]");
    //Можно ли заказать самокат прямо на сегодня?
    private final By todayOrder = By.xpath(".//*[contains(text(),'Можно ли заказать самокат прямо на сегодня?')]");
    //ответ на четвертый вопрос
    private final By fourthQuestionAnswer = By.xpath(".//*[contains(text(),'Только начиная с завтрашнего дня. Но скоро станем расторопнее.')]");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private final By orderExtend = By.xpath(".//*[contains(text(),'Можно ли продлить заказ или вернуть самокат раньше?')]");
    //ответ на пятый вопрос
    private final By fifthQuestionAnswer = By.xpath(".//*[contains(text(),'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.')]");
    //Вы привозите зарядку вместе с самокатом?
    private final By scooterCharge = By.xpath(".//*[contains(text(),'Вы привозите зарядку вместе с самокатом?')]");
    //ответ на шестой вопрос
    private final By sixthQuestionAnswer = By.xpath(".//*[contains(text(),'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.')]");
    //Можно ли отменить заказ?
    private final By orderCancel = By.xpath(".//*[contains(text(),'Можно ли отменить заказ?')]");
    //ответ на седьмой вопрос
    private final By seventhQuestionAnswer = By.xpath(".//*[contains(text(),'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.')]");
    //Я живу за МКАДом, привезёте?
    private final By outOfMoscowOrder = By.xpath(".//*[contains(text(),'Я жизу за МКАДом, привезёте?')]");
    //ответ на восьмой вопрос
    private final By eighthQuestionAnswer = By.xpath(".//*[contains(text(),'Да, обязательно. Всем самокатов! И Москве, и Московской области.')]");

    public FAQPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setQuestionClick(String question) {
        driver.findElement(By.xpath("//*[contains(text(),'" + question + "')]")).click();
    }

    public void setAnswerTextCheck(String answer) {
        driver.findElement(By.xpath(".//*[starts-with(text(),'" + answer + "')]")).getText();
    }

    public void setQuestionsAndAnswers(String question, String answer) {
        setQuestionClick(question);
        setAnswerTextCheck(answer);
    }
}
