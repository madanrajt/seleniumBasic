import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginTest {


    @Test
    public  void login() throws InterruptedException {
        RemoteWebDriver driver;
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
        driver.manage().window().maximize();
        Thread.sleep(3000);
         driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
          driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
          driver.findElement(By.xpath("//*[@type='submit']")).click();
        System.out.println("Login successful !!!!!");
        driver.close();

    }
}
