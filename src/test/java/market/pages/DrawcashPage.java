package market.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DrawcashPage extends BasePage {

    private final String url = "/bindBankCard/withraw";

    public DrawcashPage(WebDriver driver) {
        super(driver);
    }

    //提现金额输入框
    public WebElement drawamount(){
        return this.by_id("toCash");
    }

    //提现按钮
    public WebElement draw_btn(){
        return this.by_id("btn_send_code");
    }

    //徽商电子账户交易密码
    public WebElement zhifu_btn(){
        return this.by_id("encPin");
    }

    //协议复选框
    public WebElement accept_btn(){
        return this.by_id("mainAcceptIpt");
    }

    //确认按钮
    public WebElement queren_btn(){
        return this.by_id("sub");
    }

    //提现金额
    public void drawcash(String drawamount){
        this.drawamount().click();
        this.drawamount().sendKeys(drawamount);
        this.draw_btn().click();
    }

    //徽商确认提现
    public void huishang_queren(String password){
        this.zhifu_btn().sendKeys(password);
        this.accept_btn().click();
        this.queren_btn().click();
    }

    //提现成功
    public String drawsuccess_text(){
        return this.by_id("succMsg").getText();
    }

    //提交失败后服务器返回信息
    public String drawfail_text(){
        return this.by_xpath("//div[@class='credit-box txt-c']/ul/li[1]").getText();
    }

    //可用余额
    public String availableamount(){
        return this.by_class_name("balance").getText();
    }

    //提现金额输入不正确错误提示
    public String drawinput_error(){
        return this.by_id("toCasherror").getText();
    }


}
