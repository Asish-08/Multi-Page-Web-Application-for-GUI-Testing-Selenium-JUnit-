import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.HashMap;
import java.util.Map;

public class V1petstoreTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void homepageTest() {
        driver.get("http://127.0.0.1:5501/");
        driver.manage().window().setSize(new Dimension(1430, 805));
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.id("home-heading")).click();
        driver.findElement(By.cssSelector(".main-img")).click();
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("newsletter")).sendKeys("test@example.com");
        driver.findElement(By.id("agree")).click();
        driver.findElement(By.cssSelector("label:nth-child(2) > input")).click();
        driver.findElement(By.cssSelector("label:nth-child(3) > input")).click();
        driver.findElement(By.cssSelector("button")).click();
    }

    @Test
    public void browsePageTest() {
        driver.get("http://127.0.0.1:5501/");
        driver.manage().window().setSize(new Dimension(1430, 805));
        driver.findElement(By.linkText("Browse")).click();
        driver.findElement(By.id("browse-heading")).click();
        driver.findElement(By.cssSelector(".main-img")).click();
        driver.findElement(By.cssSelector("p")).click();
        driver.findElement(By.cssSelector("li:nth-child(1) > button")).click();
        assertThat(driver.switchTo().alert().getText(), is("Charlie 🐶 added to favorites!"));
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("li:nth-child(3) > button")).click();
        assertThat(driver.switchTo().alert().getText(), is("Peaches 🦜 added to favorites!"));
        driver.switchTo().alert().accept();
        driver.findElement(By.id("friendliness")).click();
        driver.findElement(By.id("reason")).click();
        driver.findElement(By.id("reason")).sendKeys("i love pets");
        driver.findElement(By.cssSelector("button:nth-child(10)")).click();
    }

    @Test
    public void favoritesPageTest() {
        driver.get("http://127.0.0.1:5501/");
        driver.manage().window().setSize(new Dimension(1430, 805));
        driver.findElement(By.linkText("Favorites")).click();
        driver.findElement(By.cssSelector("h1")).click();
        driver.findElement(By.cssSelector(".main-img")).click();
        driver.findElement(By.id("note")).click();
        driver.findElement(By.id("note")).sendKeys("i love pets");
        driver.findElement(By.cssSelector(".inline-group > p")).click();
        driver.findElement(By.name("adopt")).click();
        driver.findElement(By.id("notify")).click();
        driver.findElement(By.cssSelector("button")).click();
        assertThat(driver.switchTo().alert().getText(), is("Thanks for your interest!"));
        driver.switchTo().alert().accept();
    }

    @Test
    public void contactPageTest() {
        driver.get("http://127.0.0.1:5501/");
        driver.manage().window().setSize(new Dimension(1430, 805));
        driver.findElement(By.linkText("Contact")).click();
        driver.findElement(By.id("contact-heading")).click();
        driver.findElement(By.cssSelector(".main-img")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("jhvububed");
        driver.findElement(By.id("phone")).click();
        driver.findElement(By.id("phone")).sendKeys("36569821768343");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("phoneRadio")).click();
        driver.findElement(By.id("updates")).click();
        driver.findElement(By.cssSelector("button")).click();
    }

    @Test
    public void flowBetweenPagesTest() {
        driver.get("http://127.0.0.1:5501/");
        driver.manage().window().setSize(new Dimension(1430, 806));
        driver.findElement(By.cssSelector("button")).click();
        driver.findElement(By.cssSelector("button:nth-child(10)")).click();
        driver.findElement(By.cssSelector("button")).click();
        assertThat(driver.switchTo().alert().getText(), is("Thanks for your interest!"));
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Contact")).click();
        driver.findElement(By.cssSelector("button")).click();
    }
}