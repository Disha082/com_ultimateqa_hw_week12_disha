package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseuel = "https://courses.ultimateqa.com/";

    @Before
    public void setup(){
        openBrowser(baseuel);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Verify the text ‘Welcome Back!
        String expectedMessage = "Welcome Back!";
        WebElement actualTextMessage = driver.findElement(By.xpath("//h1[text() = 'Welcome Back!']"));
        String actualMessage = actualTextMessage.getText();
        //Compared actual and expected result
        Assert.assertEquals(expectedMessage, actualMessage);

    }
    @Test
    public void verifyTheErrorMessage (){
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        driver.findElement(By.name("user[email]")).sendKeys("xyz");
        //Enter invalid password
        driver.findElement(By.name("user[password]")).sendKeys("xyz1235");
        //Click on Sign in button
        driver.findElement(By.xpath("//input[@class = 'button button-primary g-recaptcha']")).click();
        //Varify dashboard text after login
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//li[text() = 'Invalid email or password.']"));
        String actualMessage= actualTextMessageElement.getText();

        ////Validate actual and expected
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
