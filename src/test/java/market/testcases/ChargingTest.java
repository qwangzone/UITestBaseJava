package market.testcases;

import market.driver.MyDriver;
import market.pages.ChargingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;

public class ChargingTest {
    private WebDriver dr;
    private ChargingPage chargingPage;

    @BeforeMethod
    public void setUp() {
        this.dr = new MyDriver().mydriver();
        this.chargingPage = new ChargingPage(dr);
        this.chargingPage.open();
    }

    @Test
    public void test1_content(){
        /*页面内容展示*/
        String content = this.chargingPage.get_content();
        assertTrue(content.contains("出借人收费标准"));
    }

    @AfterMethod
    public void tearDown(){
        this.dr.quit();
    }



}
