package market.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver;
    private final String base_url = "http://192.168.3.105";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        String tmp_url = this.base_url + url;
        driver.get(tmp_url);
    }

    public WebElement by_id(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement by_name(String name) {
        return driver.findElement(By.name(name));
    }

    public WebElement by_css(String css) {
        return driver.findElement(By.cssSelector(css));
    }

    public List<WebElement> by_csses(String csses) {
        return driver.findElements(By.cssSelector(csses));
    }

    public WebElement by_xpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement by_tag_name(String tag_name) {
        return driver.findElement(By.tagName(tag_name));
    }

    public WebElement by_class_name(String class_name) {
        return driver.findElement(By.className(class_name));
    }

    public void select_by_text(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void js_execute(String js) {
        JavascriptExecutor js_execute = (JavascriptExecutor) driver;
        js_execute.executeScript(js);
    }

    public WebElement by_link(String link) {
        return driver.findElement(By.linkText(link));
    }

    public void switch_alert(String alert) {
        Alert aler = driver.switchTo().alert();
        aler.accept();

    }

    //竖向拉动滚动条
    public void scroll(String size) {
        String js = "document.body.scrollTop=" + size;
        System.out.println(js);
        js_execute(js);
    }

    //封装显式等待元素是否出现
    public void ele_wait_present(By locate) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locate));
    }

    //封装显示等待元素是否可见
    public void ele_wait_visible(By locate) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locate));
    }

    // 封装鼠标悬停操作
    public void mouse_stop(WebElement locate) {
        Actions actions = new Actions(driver);
        actions.moveToElement(locate).perform();
    }

}
