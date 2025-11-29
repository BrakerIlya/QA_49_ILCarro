package ui_tests;

import dto.Car;
import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import utils.enums.HeaderMenuItem;

import java.lang.reflect.Method;
import java.util.Random;

public class LetCarWorkTests extends ApplicationManager {
    LoginPage loginPage;
    LetTheCarWorkPage letTheCarWorkPage;
    @BeforeMethod
    public void login(Method method) {
        User user = User.builder().username("bilbo_baggins_12345@mail.com").password("Password123!").build();
        new HomePage(getDriver()).clickBtnHeader(HeaderMenuItem.LOGIN);
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
//        loginPage.clickBtnOk();
        letTheCarWorkPage= loginPage.clickBtnHeader(HeaderMenuItem.LET_THE_CAR_WORK);
    }
    @Test
    public void addNewCarPositiveTest(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel("Electric")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("Гераськин2.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.btnOkPresent());
    }
    @Test
    public void addNewCarPositiveTestWManufacture(){
        Car car = Car.builder()
                .city("Haifa")
                .manufacture("Opel")
                .model("Astra")
                .year("2020")
                .fuel("Electric")
                .seats(4)
                .carClass("C")
                .serialNumber("Opel-"+ new Random().nextInt(10000))
                .pricePerDay(100.77)
                .about("about")
                .image("Гераськин2.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertTrue(letTheCarWorkPage.isTextInErrorPresent("Make is required"));
    }
}
