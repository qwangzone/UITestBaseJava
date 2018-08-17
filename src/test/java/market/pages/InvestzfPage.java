/*选择红包页面与徽商支付页面*/
package market.pages;

import org.openqa.selenium.WebDriver;

public class InvestzfPage extends BasePage {
    public InvestzfPage(WebDriver driver) {
        super(driver);
    }

    //立即支付按钮
    public void zhifu_btn() {
        this.by_css(".dis-ib>button[name='btn_send_m_code']").click();
    }

    //徽商页面操作流程
    public void huishang(String password) throws InterruptedException {
        this.by_id("pass").sendKeys(password);
        this.by_id("mainAcceptIpt").click();
        Thread.sleep(3000);
        this.by_id("sub").click();

    }
}
