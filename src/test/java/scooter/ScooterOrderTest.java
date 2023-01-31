package scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import scooter.pageObjects.ScooterOrderPageObject;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScooterOrderTest {
    private final String orderButton;
    private final String username;
    private final String userLastname;
    private final String userHomeAddress;
    private final String userMetroStation;
    private final String userPhoneNumber;
    private final String inputDate;
    private final String dropdownPeriod;
    private final String colorId;
    private final String comment;
    private final boolean сonfirmOrderWindow;

    public ScooterOrderTest(String orderButton, String username, String userLastname, String userHomeAddress, String userMetroStation, String userPhoneNumber, String inputDate, String dropdownPeriod, String colorId, String comment, boolean сonfirmOrderWindow) {
        this.orderButton = orderButton;
        this.username = username;
        this.userLastname = userLastname;
        this.userHomeAddress = userHomeAddress;
        this.userMetroStation = userMetroStation;
        this.userPhoneNumber = userPhoneNumber;
        this.inputDate = inputDate;
        this.dropdownPeriod = dropdownPeriod;
        this.colorId = colorId;
        this.comment = comment;
        this.сonfirmOrderWindow = сonfirmOrderWindow;
    }

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().deleteAllCookies();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Header", "Ирина", "Василенко", "г Москва, ул. Мира, дом 4", "Проспект Мира", "89154865278", "28.01.2023", "сутки", "чёрный жемчуг", "Нет домофона", true},
                {"Button", "Алена", "Иванова", "г Москва, ул. Трифоновская, дом 16", "Рижская", "89567423158", "25.02.2023", "трое суток", "серая безысходность", "Не звонить с утра", true},
        };
    }

    @Test
    public void scooterOrderTest() {
        ScooterOrderPageObject objScooterOrderPageObject = new ScooterOrderPageObject(driver);
        objScooterOrderPageObject.firstOrderForm(orderButton, username, userLastname, userHomeAddress, userMetroStation, userPhoneNumber, inputDate, dropdownPeriod, colorId, comment);
        boolean result = true;
        assertEquals("Окно с подтверждением заказа появилось", result, сonfirmOrderWindow);
    }
}
