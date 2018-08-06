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


}
