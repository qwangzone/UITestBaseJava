/*标的详情页，投资使用*/
package market.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZhitouXqPage extends BasePage{
    private final String url = "/licai/60232";
    public ZhitouXqPage(WebDriver driver) {
        super(driver);
    }

    //金额输入框
    public WebElement amount_input(){
        return this.by_id("amount");
    }

    //立即出借按钮
    public WebElement submit_btn(){
        return this.by_class_name("submitbtn");
    }

    //确认按钮(风险提示确认)
    public WebElement queren(){
        return this.by_id("okcp");
    }

    //投资流程
    public InvestzfPage invest(String money) throws InterruptedException {
        this.amount_input().sendKeys(money);
        this.submit_btn().click();
        this.queren().click();
        Thread.sleep(3000);
        return new InvestzfPage(driver);
    }

    // 打开页面动作
    public void open(){
        this.open(url);
    }

    //错误信息
    public String input_error_text(){
        return this.by_id("hint").getText();
    }

    //账户余额
    public String remain_text(){
        return this.by_xpath("//*[@id='submitform']/div[2]/span").getText();
    }

    //剩余可投
    public String remain_invest_text(){
        return this.by_xpath("//*[@id='submitform']/div[1]/span").getText();
    }


}
