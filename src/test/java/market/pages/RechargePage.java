/*充值金额页面*/
package market.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RechargePage extends BasePage {
    private final String url =  "/recharge";
    public RechargePage(WebDriver driver) {
        super(driver);
    }

    //输入充值金额
    public WebElement recharge_amount(){
        return this.by_id("amount");
    }

    //选择网银支付银行
    public WebElement icbc_btn(){
        return this.by_id("icbc");
    }

    //选择确认按钮
    public WebElement queren_btn(){
        return this.by_id("confirm");
    }

    //充值
    public void recharge(String money){
        this.open(this.url);
        this.recharge_amount().sendKeys(money);
        this.icbc_btn().click();
        this.queren_btn().click();
    }

    /*丰付页面，需切换handle*/

    //银行卡号
    public WebElement cardnumber(){
        return this.by_id("CARD_NO");
    }

    //卡密码
    public WebElement password(){
        return this.by_id("PASSWORD");
    }

    //支付按钮
    public WebElement pay_btn(){
        return this.by_xpath("//form[@id='payform']/table/tbody/tr[8]/td[1]/input[1]");
    }

    //支付后点击返回才回调
    public WebElement return_btn(){
        return this.by_xpath("//form[@id='retrunform']/table/tbody/tr[6]/td/input[1]");
    }

    //输入测试卡信息进行充值
    public void sumapay(String cardnumber, String password){
        this.cardnumber().sendKeys(cardnumber);
        this.password().sendKeys(password);
        this.pay_btn().click();
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }

        this.return_btn().click();
    }
}
