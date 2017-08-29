package finalTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	static WebDriver d;
	Logger log = Logger.getLogger("vvv");
	public String workingDir;


	protected static WebElement xp(String xpath) {

		return  d.findElement(By.xpath(xpath));
	}

	protected static WebElement id(String id) {

		return  d.findElement(By.id(id));
	}
	protected static WebElement css(String cssSelector) {

		return  d.findElement(By.cssSelector(cssSelector));
	}

	void browserOpen() throws InterruptedException {
		workingDir = System.getProperty("user.dir");
		// BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver",workingDir+ "\\Resources\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	void logIn() throws Exception {
		File file = new File(workingDir + "\\Resources\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.get(prop.getProperty("URL"));
		log.info("Opening Techfetch webiste");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Thread.sleep(10000);
		xp(prop.getProperty("candidatelogin")).click();
		log.info("Opening candidate menu");
		Thread.sleep(1000);
		xp(prop.getProperty("loginbutton")).click();
		log.info("Clicking Login button");
		d.switchTo().defaultContent();
		d.switchTo().frame("candidatecontentframe");

		xp(prop.getProperty("mailid")).sendKeys(prop.getProperty("username"));
		log.info("Entering mailid");

		xp(prop.getProperty("password1")).sendKeys(prop.getProperty("password"));
		log.info("Entering password");

		xp(prop.getProperty("submitbutton")).click();
		log.debug("Clicking submit button");

		Thread.sleep(1000);

	}

	void logOut() throws Exception {

		d.switchTo().defaultContent();

		Thread.sleep(10000);
		File file = new File(workingDir+"\\Resources\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		// Logout...
		xp(prop.getProperty("usersetting")).click();
		log.debug("Clicking user settings ");
		Thread.sleep(10000);
		xp(prop.getProperty("logoutbutton")).click();
		log.debug("Clicking logout button ");
		Thread.sleep(10000);
	}

	void browserClose() {
		d.quit();
	}

}
