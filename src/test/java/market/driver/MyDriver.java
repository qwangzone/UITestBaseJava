package market.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyDriver {
    private WebDriver dr;
    public WebDriver mydriver(){
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        return dr;
    }
}
