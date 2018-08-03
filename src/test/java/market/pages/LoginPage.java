package market.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final String url = "/user/login";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement input_username() {
        return this.by_id("mobile");
    }

    public WebElement input_pass() {
        return this.by_id("loginPass");
    }

    public WebElement input_yanzheng() {
        return this.by_id("captchaCode");
    }

    public WebElement login_btn() {
        return this.by_class_name("registerok");
    }

    public WebElement register_link() {
        return this.by_link("立即注册");
    }

    public WebElement homepage_link() {
        return this.by_link("返回首页");
    }

    public WebElement mobilem_error() {
        return this.by_class_name("mobilem");
    }

    public WebElement loginPassm_error() {
        return this.by_class_name("loginPassm");
    }

    public WebElement captchaCodem_error() {
        return this.by_class_name("captchaCodem");
    }

    //登录操作
    public void login(String username,String password,String yanzhneg) throws InterruptedException {
        System.out.println(this.url);
        this.open(this.url);
        this.input_username().sendKeys(username);
        this.input_pass().sendKeys(password);
        this.input_yanzheng().sendKeys(yanzhneg);
        this.login_btn().click();
        Thread.sleep(3000);
    }

    //获取用户输入框错误提示
    public String mobilem_error_text(){
        return this.mobilem_error().getText();
    }

    //获取登录密码输入框错误提示
    public String loginPassm_error_text(){
        return this.loginPassm_error().getText();
    }

    //获取验证码输入框错误提示
    public String captchaCodem_error_text(){
        return this.captchaCodem_error().getText();
    }
}
