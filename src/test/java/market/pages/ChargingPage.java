/*收费标准页面*/
package market.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChargingPage extends BasePage {
    private final String url = "/information/rates";

    public ChargingPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        super.open(url);
    }

    public WebElement content() {
        return this.by_class_name("xf_mainRight");
    }

    public String get_content(){
        return this.content().getAttribute("innerHTML");
    }
}
