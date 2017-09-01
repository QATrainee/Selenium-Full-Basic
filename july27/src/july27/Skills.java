package july27;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import org.testng.annotations.*;
//import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Skills {
 WebDriver driver;
  String baseUrl;

  public static void main(String[] args) throws InterruptedException, IOException
  {

	  FileInputStream fileInput = new FileInputStream("data.properties");
	// Create Properties object
	Properties prop = new Properties();
	//load properties file
	prop.load(fileInput);
	//// WebDriver reference but Firefox object 

	  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jarfiles\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();

	
	  
driver.manage().window().maximize();

//Visit to Facebook
driver.get(prop.getProperty("URL"));
Thread.sleep(2000);
//Read Username from Properties and send to facebook Username text field
driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click();
Thread.sleep(2000);
driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
//driver.manage().timeouts().implicitlywait();
driver.switchTo().defaultContent();

driver.switchTo().frame("candidatecontentframe");
driver.findElement(By.id("txtemailid")).sendKeys(prop.getProperty("Username"));
//Read Password from Properties and send to facebook password text field
driver.findElement(By.id("txtpwd")).sendKeys(prop.getProperty("Password"));
Thread.sleep(2000);
driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
Thread.sleep(10000);
//driver.switchTo().defaultContent();
//driver.switchTo().frame("contentframe");
Thread.sleep(1000);

	  
	 // driver.switchTo().frame("contentframe");
		//  driver.get("http://uat.techfetch.com/JS/JS_My_Resume.aspx");


driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[2]/a")).click();
Thread.sleep(1000);
driver.findElement(By.xpath(".//*[@id='editresumetab']")).click();
Thread.sleep(3000)
;
driver.switchTo().defaultContent();
driver.switchTo().frame("contentframe");
Thread.sleep(3000);
	    driver.findElement(By.xpath(".//*[@id='Skillsli']/a")).click();

    new Select(driver.findElement(By.id("ddlSpecializedArea"))).selectByVisibleText("Java, J2EE");
    new Select(driver.findElement(By.id("ddlSpecializedSkill"))).selectByVisibleText("Java Front End");
    driver.findElement(By.id("txtSkill1")).clear();
    driver.findElement(By.id("txtSkill1")).sendKeys("infosys");
    new Select(driver.findElement(By.id("ddlYears1"))).selectByVisibleText("2");
    driver.findElement(By.id("btnSkills")).click();
   Thread.sleep(30000);
    
    //driver.findElement(By.id("Skillsli")).click();
    driver.findElement(By.cssSelector("#Preferencesli > a")).click();
    driver.findElement(By.id("chkBusinessDomaintelecom")).click();
    driver.findElement(By.id("radPublishToAll")).click();
    driver.findElement(By.id("chkprefjobyes")).click();
    driver.findElement(By.id("btnPreferences")).click();
    Thread.sleep(30000);
   
  //  driver.findElement(By.id("Preferencesli")).click();

    /*
    driver.findElement(By.xpath(".//*[@id='JobAlertli']/a")).click();
  
    driver.findElement(By.id("chkcontarctjobtype")).click();
    new Select(driver.findElement(By.xpath(".//*[@id='ddlYears']"))).selectByVisibleText("2");
    driver.findElement(By.cssSelector("#ddlYears > option[value=\"2\"]")).click();
    new Select(driver.findElement(By.id("ddlFetchAlertMax"))).selectByVisibleText("3");
    driver.findElement(By.cssSelector("#ddlFetchAlertMax > option[value=\"3\"]")).click();
      driver.findElement(By.xpath(".//*[@id='chkjobalert']")).click();
    driver.findElement(By.id("btnJobAlert")).click();
    driver.findElement(By.id("JobAlertli")).click();
    Thread.sleep(3000);*/
    
    
    
    

    
    driver.findElement(By.xpath(".//*[@id='JobAlertli']/a")).click();
    driver.findElement(By.id("chkcontarctjobtype")).click();
    new Select(driver.findElement(By.id("ddlYears"))).selectByVisibleText("3");
    driver.findElement(By.cssSelector("#ddlYears > option[value=\"3\"]")).click();
    new Select(driver.findElement(By.id("ddlFetchAlertMax"))).selectByVisibleText("3");
    driver.findElement(By.cssSelector("#ddlFetchAlertMax > option[value=\"3\"]")).click();
    driver.findElement(By.id("btnJobAlert")).click();
    Thread.sleep(30000);
    //driver.findElement(By.id("Professionalli")).click();
    driver.findElement(By.linkText("Special Notes(complete)")).click();
    driver.findElement(By.id("txtCandidateEmailId")).clear();
    driver.findElement(By.id("txtCandidateEmailId")).sendKeys("balapriyam95@yahoo.com");
    driver.findElement(By.id("btnSpecialNotes")).click();
   // driver.findElement(By.id("Professionalli")).click();
    Thread.sleep(30000);

    
    
  /*  driver.findElement(By.xpath(".//*[@id='SpecialNotesli']/a")).click();
    driver.findElement(By.id("txtCandidateEmailId")).clear();
    driver.findElement(By.id("txtCandidateEmailId")).sendKeys("balapriyam95@yahoo.com");
    driver.findElement(By.id("btnSpecialNotes")).click();
    driver.findElement(By.id("SpecialNotesli")).click();*/
    System.out.println("saved");
    driver.close();
  }

 

  }


