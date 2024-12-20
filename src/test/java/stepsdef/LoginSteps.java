package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;
    @Given("user opens homepage and click on login link")
    public void user_opens_homepage_and_click_on_login_link(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Form Authentication")).click();
    }
    @When("user enter valid username and valid password and press login")
    public void user_enter_valid_username_and_valid_password_and_press_login() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

    }


    @Then("user is switched to SecureArea Page")
    public void userIsSwitchedToSecureAreaPage() {
        String actualresult = driver.findElement(By.cssSelector(".flash.success")).getText();
        String expectedresult = "You logged into a secure area!";

        Assert.assertTrue(actualresult.contains(expectedresult));

    }

    @When("user enter invalid username and valid password and press login")
    public void userEnterInvalidUsernameAndValidPasswordAndPressLogin() {
        driver.findElement(By.id("username")).sendKeys("tom");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        String actualresult = driver.findElement(By.cssSelector(".flash.error")).getText();
        String expectedresult = "Your username is invalid!";

        Assert.assertTrue(actualresult.contains(expectedresult));

    }
}
