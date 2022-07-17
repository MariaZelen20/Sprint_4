package test;

import home.MainPage;
import home.Order;
import home.OrderDetailsFormPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

//    @RunWith(Parameterized.class)
public class MakeOrderTest extends BaseUITest{


    public MakeOrderTest(WebDriver driver) {
        super(driver);
    }


    @Test
    public void makeOrder() {
        Order order = new Order("Мария", "Зеленова", "Москва, Красносельская", "Красносельская", "+79371730518");
        OrderDetailsFormPage isInputDataBlockDisplayed = new MainPage(driver)
                .openUrl()
                .acceptCookie()
                .clickOrderButtonOverhead()
                .fillOrderDetailsForm(order);

    }
}
