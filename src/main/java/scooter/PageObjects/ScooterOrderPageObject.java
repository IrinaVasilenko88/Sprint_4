package scooter.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderPageObject {
    private WebDriver driver;

    //верхняя кнопка Заказать
    private final By orderButtonTop = By.xpath("//*[contains(@class, 'Header')]//button[text()='Заказать']");
    //поле Имя
    private final By inputName = By.xpath(".//*[@Placeholder='* Имя']");
    //поле Фамилия
    private final By inputLastName = By.xpath(".//*[@Placeholder='* Фамилия']");
    //поле Адрес
    private final By homeAddress = By.xpath("//*[@Placeholder='* Адрес: куда привезти заказ']");
    //поле Метро
    private final By metroStation = By.xpath(".//*[@Placeholder='* Станция метро']");
    //поле Номер телефона
    private final By inputPhoneNumber = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее
    private final By buttonFurther = By.xpath("//*[contains(@class,'Button')]//*[text()='Далее']");
    //кнопка Принять куки
    private final By cookieButton = By.id("rcc-confirm-button");
    //поле Когда привезти самокат
    private final By whenToBring = By.xpath("//*[contains(@class,'react')]//input[@placeholder='* Когда привезти самокат']");
    //поле Срок аренды
    private final By rentalPeriod = By.xpath("//*[contains(@class,'Drop')]//span[@class='Dropdown-arrow']");
    //цвет самоката черный жемчуг
    private final By colorBlack = By.xpath("//*[contains(text(),'чёрный жемчуг')]");
    //цвет самоката серый
    private final By colorGrey = By.xpath("//*[contains(text(),'серая безысходность')]");
    //поле Комментарии для курьера
    private final By commentsForCourier = By.xpath("//*[contains(@class,'Input')]//input[@placeholder='Комментарий для курьера']");
    //отправка формы Заказа
    private final By sendOrderForm = By.xpath("//*[contains(@class,'Button')]//button[text()='Заказать']");
    //окно с подтверждением Заказа
    private final By orderConfirmWindow = By.className("Order_Modal__YZ-d3");

    public ScooterOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }


    //метод нажимает кнопку Заказать
    public void orderButtonClick(String orderButton) {
        driver.findElement(cookieButton).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButtonTop));

        WebElement element = driver.findElement(By.xpath("//*[contains(@class, '" + orderButton + "')]//button[text()='Заказать']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath("//*[contains(@class, '" + orderButton + "')]//button[text()='Заказать']")).click();
    }

    //метод заполняет поле Имя
    public void setInputName(String username) {
        driver.findElement(inputName).sendKeys(username);
    }

    //метод заполняет поле Фамилия
    public void setInputLastName(String userLastname) {
        driver.findElement(inputLastName).sendKeys(userLastname);
    }

    //метод заполняет поле Адрес
    public void setHomeAddress(String userHomeAddress) {
        driver.findElement(homeAddress).sendKeys(userHomeAddress);
    }

    //метод выбирает станцию метро из списка
    public void selectMetroStation(String userMetroStation) {
        driver.findElement(metroStation).click();
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'select-search')]//ul")));
        driver.findElement(By.xpath("//*[contains(@class, 'select-search')]//*[text()='" + userMetroStation + "']")).click();
    }

    //метод заполняет поле Телефон
    public void setInputPhoneNumber(String userPhoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(userPhoneNumber);
    }

    //метод нажимает кнопку Далее
    public void setButtonFurther() {
        driver.findElement(buttonFurther).click();
    }

    //метод заполняет поле Когда привезти самокат
    public void setWhenToBring(String inputDate) {
        driver.findElement(whenToBring).sendKeys(inputDate);
    }

    //метод заполняет поле Срок аренды
    public void setRentalPeriod(String dropdownPeriod) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath("//*[contains(@class,'Drop')]//div[text()='" + dropdownPeriod + "']")).click();
    }

    //метод выбирает цвет скутера
    public void setScooterColor(String colorId) {
        driver.findElement(By.xpath("//*[contains(text(),'" + colorId + "')]")).click();
    }

    //метод заполняет поле Комментарии для курьера
    public void setCommentForCourier(String comment) {
        driver.findElement(commentsForCourier).sendKeys(comment);
    }

    //метод нажимает кнопку Заказать после заполнения всех полей
    public void clickSendOrderForm() {
        driver.findElement(sendOrderForm).click();
    }

    //модальное окно Подтверждения заказа
    public void orderConfirmWindow() {
        driver.findElement(orderConfirmWindow).isDisplayed();
    }

    public void firstOrderForm(String orderButton, String username, String userLastname, String userHomeAddress, String userMetroStation, String userPhoneNumber, String inputDate, String dropdownPeriod, String colorId, String comment) {
        orderButtonClick(orderButton);
        setInputName(username);
        setInputLastName(userLastname);
        setHomeAddress(userHomeAddress);
        selectMetroStation(userMetroStation);
        setInputPhoneNumber(userPhoneNumber);
        setButtonFurther();
        setWhenToBring(inputDate);
        setRentalPeriod(dropdownPeriod);
        setScooterColor(colorId);
        setCommentForCourier(comment);
        clickSendOrderForm();
        orderConfirmWindow();
        orderButtonClick(orderButton);

    }


}
