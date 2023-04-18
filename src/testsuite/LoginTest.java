package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before // JUnit Annotation which will run before every method
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test // JUnit Annotation which will allow executing this method
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.xpath("//input[@placeholder ='Username']")).sendKeys("Admin");// Find username field and enter valid username
        driver.findElement(By.name("password")).sendKeys("admin123"); //Find password field and enter valid password
        driver.findElement(By.xpath("//button[@type ='submit']")).click();//Find submit button and click on it
        String expectedMessage = "Dashboard"; // Expected message given from requirement
        String actualMessage = driver.findElement(By.xpath("//h6[@class ='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText(); // Finding Dashboard text element and getting the text
        Assert.assertEquals("User was not able to login successfully.",expectedMessage, actualMessage); // Validating actual and expected message
    }

    @After // JUnit Annotation which will run after every method
    public void tearDown() {
        closeBrowser();
    }

}
