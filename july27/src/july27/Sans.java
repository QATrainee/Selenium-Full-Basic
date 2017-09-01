

package july27;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


//import org.apache.bcel.generic.Select;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sans {

public static void main(String[] args) throws InterruptedException {
try {
// Create FileInputStream Object
FileInputStream fileInput = new FileInputStream(new File("data.properties"));
// Create Properties object
Properties prop = new Properties();
//load properties file
prop.load(fileInput);
System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jarfiles\\chromedriver.exe");
WebDriver driver = new ChromeDriver(); 
//Maximize browser window

driver.manage().window().maximize();
Thread.sleep(2000);

//Visit to tech
driver.get(prop.getProperty("URL"));
Thread.sleep(1000);
driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click();

driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
driver.switchTo().defaultContent();
driver.switchTo().frame("candidatecontentframe");
Thread.sleep(2000);
driver.findElement(By.id("txtemailid")).sendKeys(prop.getProperty("Username"));
//Read Password from Properties and send to facebook password text field
driver.findElement(By.id("txtpwd")).sendKeys(prop.getProperty("Password"));
Thread.sleep(2000);
driver.findElement(By.id("btnSubmit")).click();
//driver.switchTo().defaultContent();
// driver.switchTo().frame("contentframe");
//job alerts tab
Thread.sleep(10000);
driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[4]/a[1]")).click();


//create job alert
Thread.sleep(2000);
driver.findElement(By.xpath(".//*[@id='createjobalerttab']")).click();
driver.switchTo().defaultContent();
driver.switchTo().frame("contentframe");
Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='ddlProfile']")));
oSelect.selectByIndex(5);
// driver.findElement(By.xpath(".//*[@id='txtExclukeywords']")).sendKeys("work from home");
driver.findElement(By.xpath(".//*[@id='txtExclucompname']")).sendKeys("techebuzz");
Thread.sleep(2000);
// driver.findElement(By.xpath(".//*[@id='chkDailyemail']")).click();
// driver.findElement(By.xpath(".//*[@id='chkjobalert']")).click();
// Select oselect2 = new Select(driver.findElement(By.xpath(".//*[@id='ddlFetchAlertMax']")));
// oselect2.selectByIndex(2);

driver.findElement(By.xpath(".//*[@id='btnSaveAlert']")).click();
Thread.sleep(2000);
driver.switchTo().defaultContent();
//alert list
driver.findElement(By.xpath(".//*[@id='alertlist']")).click();
Thread.sleep(2000);
driver.switchTo().defaultContent();
driver.switchTo().frame("contentframe");
driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[1]/div/input")).sendKeys("Jul 27 2017");
// driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[2]/div/input")).sendKeys("dinesh");
// driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[3]/div/input")).sendKeys("dinesh");
Select oselect = new Select(driver.findElement(By.xpath(".//*[@id='consstatus-filter']")));
oselect.selectByIndex(0);
Select oselect1 = new Select(driver.findElement(By.xpath(".//*[@id='insstatus-filter']")));
oselect1.selectByIndex(0);
Thread.sleep(1000);
//delete alert
driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/tbody/tr[2]/td[7]/a/img")).click();
driver.switchTo().alert().accept();
Thread.sleep(2000);
// back to alert for matched jobs
driver.switchTo().defaultContent();
driver.findElement(By.xpath(".//*[@id='alertlist']")).click();
Thread.sleep(2000);
driver.switchTo().defaultContent();
driver.switchTo().frame("contentframe");
// driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[1]/div/input")).sendKeys("Jul 24 2017");
driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[2]/div/input")).sendKeys("doles");
// driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/thead/tr[2]/td[3]/div/input")).sendKeys("doles");
Select oselect2 = new Select(driver.findElement(By.xpath(".//*[@id='consstatus-filter']")));
oselect2.selectByIndex(0);
Select oselect3 = new Select(driver.findElement(By.xpath(".//*[@id='insstatus-filter']")));
oselect3.selectByIndex(0);


//matched jobs
driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/tbody/tr[2]/td[6]/a")).click();
driver.switchTo().defaultContent();
driver.switchTo().frame("contentframe");
Thread.sleep(3000);
driver.findElement(By.xpath(".//*[@id='ctl06_lnkLogin']")).click();
driver.switchTo().defaultContent();
driver.switchTo().frame("applyemailframe");
//driver.findElement(By.xpath(".//*[@id='txtCC']")).sendKeys("trainee5"
	//	+ "@tiliconveli.com");
// driver.findElement(By.xpath(".//*[@id='fileCL']"));
Thread.sleep(10000);
driver.findElement(By.xpath(".//*[@id='fileCL']")).click();







} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
} catch (NoSuchElementException e) {
e.printStackTrace();
}

}
}
