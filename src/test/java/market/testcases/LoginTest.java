package market.testcases;

import market.driver.MyDriver;
import market.pages.LoginPage;
import market.pages.MyAcountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class LoginTest {
    private WebDriver dr;
    private LoginPage lg;

    @BeforeMethod
    public void setUp() {
//        this.dr = new ChromeDriver();
//
//        this.dr.manage().window().maximize();
        MyDriver driver = new MyDriver();
        dr = driver.mydriver();
        this.lg = new LoginPage(dr);
    }

    @Test
    public void test1_username_error() throws InterruptedException {
        //this.dr.get("http://www.baidu.com");
        this.lg.login("11111", "123456", "1");
        Thread.sleep(3000);
        String text1 = this.lg.mobilem_error_text();
        assertEquals(text1, "*该账户不存在");
    }

    @Test
    public void test2_password_error() throws InterruptedException {
        this.lg.login("13658524695", "1111", "1");
        Thread.sleep(3000);
        String text2 = this.lg.loginPassm_error_text();
        assertEquals(text2, "*密码与账户不匹配");
    }

    @Test
    public void test3_login_success() throws InterruptedException {
        MyAcountPage my = this.lg.login("13658524695", "123456", "1");
        Thread.sleep(3000);
        String text3 = my.login_success_text();
        //System.out.println(text3);
        assertTrue(text3.contains("账户总览"));

    }

    @AfterMethod
    public void tearDown() {
        this.dr.quit();
    }
}
