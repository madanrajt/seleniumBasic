import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginTest {


    public static void main(String[] args) throws InterruptedException {
        RemoteWebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElementById("txtUsername").sendKeys("Admin");
        driver.findElementById("txtPassword").sendKeys("admin123");
        driver.findElementById("btnLogin").click();
        driver.close();

    }
}
