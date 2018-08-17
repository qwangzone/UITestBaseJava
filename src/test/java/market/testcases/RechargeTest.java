package market.testcases;

import market.driver.MyDriver;
import market.pages.LoginPage;
import market.pages.MyAcountPage;
import market.pages.RechargePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.jnlp.DownloadService;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class RechargeTest {
    private WebDriver dr;
    private RechargePage rechargePage;
    private LoginPage loginPage;
    private MyAcountPage myAcountPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        this.dr = new MyDriver().mydriver();
        this.rechargePage = new RechargePage(this.dr);
        this.loginPage = new LoginPage(this.dr);
        this.myAcountPage = this.loginPage.login("13658524695", "123456", "1");
    }

    @Test
    public void test1_recharge_success() throws InterruptedException {
        Double amount_before = Double.parseDouble(this.myAcountPage.avaliable_amount().replace(",", ""));
        System.out.println(amount_before);
        this.rechargePage.recharge("100");
        Set<String> handles = this.dr.getWindowHandles();
        String current_handle = this.dr.getWindowHandle();
        for (String handle : handles) {
            System.out.println(handle);
            if (!handle.equals(current_handle)) {
                this.dr.switchTo().window(handle);
                String current_handle1 = this.dr.getWindowHandle();
            }
        }

        Thread.sleep(8000);
        this.rechargePage.sumapay("4417120412174596", "289017");
        Thread.sleep(8000);
        this.myAcountPage.open();
        Double amount_after = Double.parseDouble(this.myAcountPage.avaliable_amount().replace(",", ""));
        System.out.println(amount_after);
        Double recharge_amount = amount_after - amount_before;
        assertEquals(recharge_amount, 100.0);

    }

    @AfterMethod
    public void tearDown() {
        this.dr.quit();
    }

//    public static void main(String[] args){
//        String wq = "20969.3";
//        int a = 12;
//        Integer a1 = 123;
//        a1.toString();
//        Double w = 12.12;
//        System.out.println(Double.compare(12.2,2.33));
//        System.out.println(Double.parseDouble(wq));
//        System.out.println(Double.valueOf(wq).doubleValue());
//    }
}
