package market.testcases;

import market.driver.MyDriver;
import market.pages.InvestzfPage;
import market.pages.LoginPage;
import market.pages.ZhitouXqPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvestTest {
    private WebDriver dr;
    private LoginPage loginPage;
    private InvestzfPage investzfPage;
    private ZhitouXqPage zhitouXqPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        this.dr = new MyDriver().mydriver();
        this.loginPage = new LoginPage(this.dr);
        this.loginPage.login("13658524695","123456","1");
        Thread.sleep(3000);
        this.zhitouXqPage = new ZhitouXqPage(this.dr);
    }

    @AfterClass
    public void tearDown(){
        this.dr.quit();
    }

    @Test
    public void test1_invest_success() throws InterruptedException {
        this.zhitouXqPage.open();
        Double zhanghuyue_before = Double.parseDouble(this.zhitouXqPage.remain_text().replace(",",""));
        this.investzfPage = this.zhitouXqPage.invest("100");
        this.investzfPage.zhifu_btn();
        Thread.sleep(3000);
        this.investzfPage.huishang("123456");
        Thread.sleep(3000);
        this.zhitouXqPage.open();
        Double zhanghuyue_after = Double.parseDouble(this.zhitouXqPage.remain_text().replace(",",""));
        Double diff = zhanghuyue_before - zhanghuyue_after;
        assertEquals(diff,100.0);
    }
}
