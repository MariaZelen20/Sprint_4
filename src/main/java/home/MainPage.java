package home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage  {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openUrl() {
        driver.get(URL);
        return this;
    }
    //верхняя кнопка "заказать"
    private final By orderButtonOverhead = By.xpath("html/body/div/div/div/div/div/button[@class='Button_Button__ra12g']");
    //нижняя кнопка "заказать"
    private final By orderButtonUnderarm = By.className("Button_Middle__1CSJM");
    // Поле ввода номера заказа
    private final By orderCheckInput = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    // Кнопка Go
    private final By searchOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    // Кнопка статус заказа
    private final By orderStatusButton = By.className("Header_Link__1TAG7");

    // Поле ввода номера заказа
    private final By orderNameInput = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");

    //Кнопка подтверждения куки
    private final By cookie = By.id("rcc-confirm-button");


    // Кликнуть поиск заказа
    public MainPage enterOrderNumber(String orderNumber) {
        driver.findElement(orderNameInput).sendKeys(orderNumber);
        return this;
    }
    // Кнопка поиска заказа
    public OrderStatusPage clickSearchOrderButton() {
        driver.findElement(searchOrderButton).click();
        return new OrderStatusPage(driver);
    }
    // Скролл до аккордеона
    public MainPage scrollToQuestion() {
        WebElement element = driver.findElement(By.className("Home_FAQ__3uVm4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    //Кнопки с вопросами
    public static String questionButton = "accordion__heading-%s";
    // Ответы на вопросы
    public static String questionText = "accordion__panel-%s";
    //Динамический номер для локатора кнопок
    public static By accordionButton(String number) {
        return By.id(String.format(questionButton, number));
    }
    //Динамический номер для локатора ответов
    public static By accordionText(String number) {
        return By.id(String.format(questionText, number));
    }

    //Клик по кнопкам с вопросами (аккордеон)
    public MainPage clickQuestionButton(String number) {
        driver.findElement(accordionButton(number)).click();
        return this;
    }
    //Возвращение текста ответов на вопросы (аккордеон)
    public String getQuestionText(String number) {
        return driver.findElement(accordionText(number)).getText();
    }

    //метод подтверждения куки
    public MainPage acceptCookie(){
        driver.findElement(cookie).click();
        return this;
    }

    public MainPage clickOrderButtonOverhead(){
        driver.findElement(orderButtonOverhead).click();
        return this;
    }

    public OrderDetailsFormPage fillOrderDetailsForm(Order order){
        return new OrderDetailsFormPage(driver);
    }


}