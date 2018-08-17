package market.pages;

import org.openqa.selenium.WebDriver;

public class MyAcountPage extends BasePage{
    private final String url = "/user/";
    public MyAcountPage(WebDriver driver) {
        super(driver);
    }

    public String login_success_text(){
        return this.by_css("li.subNav>a").getText();
    }

    //打开我的账户页面
    public void open(){
        this.open(this.url);
    }

    //风险承受能力
    public String riskrate(){
        return this.by_xpath("/html/body/div[6]/div[5]/div[1]/div[1]/div[2]/a").getText();
    }

    //账户总资产
    public String total_assets(){
        return this.by_class_name("ft36").getText();
    }

    //待收收入
    public String due_income(){
        return this.by_xpath("//table[@class='table']/tbody/tr[1]/td[2]").getText();
    }

    //待收本金
    public String due_prinple(){
        return this.by_xpath("//table[@class='table']/tbody/tr[2]/td[2]").getText();
    }

    //已赚收入
    public String earned_income(){
        return this.by_xpath("//table[@class='table']/tbody/tr[3]/td[2]").getText();
    }

    //处理中金额
    public String amount_in_process(){
        return this.by_xpath("//table[@class='table']/tbody/tr[4]/td[2]").getText();
    }

    //可用余额
    public String avaliable_amount(){
        return this.by_xpath("//div[@class='m-center randw pt1']/h1").getText();
    }

    //登录成功用户名
    public String login_user(){
        return this.by_id("acountmobile").getText();
    }

    //账户总览充值入口
    public RechargePage account_pay(){
        this.by_link("充值").click();
        return new RechargePage(driver);
    }

    //账户总览提现入口
    public DrawcashPage draw_btn(){
        this.by_link("提现").click();
        return new DrawcashPage(driver);
    }

}
