package techfetch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Techfetch2 {
	// File file = new
	// File("E:\\workspace\\TechFetch.Automation\\Locator.properties");
	WebDriver driver;
	Logger log = Logger.getLogger("devpinoyLogger");
	

	
@Test 
	public void login() throws IOException, InterruptedException {
		// Login to techfetch candidate
		/**
		 * @author Arun Sakthi work name : login
		 */
	BasicConfigurator.configure();
	
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jarfiles\\chromedriver.exe");
	driver = new ChromeDriver();
	
	FileInputStream fsIP = new FileInputStream(new File(
			"D:\\Workspace\\Final.automation\\ss.xlsx"));
	XSSFWorkbook wb = new XSSFWorkbook(fsIP);
	XSSFSheet worksheet = wb.getSheetAt(0);
	Cell cell;

	
		File file = new File("D:\\Workspace\\TechFetch.Automation\\Locator.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
	for (int i = 0; i <= 5; i++) {
			
			Thread.sleep(1000);
		driver.get(prop.getProperty("URL"));
		log.info("Opening Techfetch webiste");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click();
		log.info("Opening candidate menu");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
		log.info("Clicking Login button");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("candidatecontentframe");

		driver.findElement(By.xpath("//.//*[@id='txtemailid']")).sendKeys(prop.getProperty("username"));
		log.info("Entering mailid");

		driver.findElement(By.xpath("//.//*[@id='txtpwd']")).sendKeys(prop.getProperty("password"));
		log.info("Entering password");

		driver.findElement(By.xpath("//.//*[@id='btnSubmit']")).click();
		log.info("Clicking submit button");
		try {
			WebElement web1 = driver.findElement(By
					.xpath(".//*[@id='login']/div[1]/div"));
			boolean a2 = web1.isDisplayed();
			if (a2 = true) {
				cell = worksheet.getRow(i).createCell(2);
				cell.setCellValue("Login fail,,,");
				fsIP.close();
				FileOutputStream output_file1 = new FileOutputStream(
						new File("D:\\Workspace\\Final.automation\\ss.xlsx"));
				wb.write(output_file1);
				output_file1.close();

				Thread.sleep(1000);
			}
		}
		catch (Exception e) {
			cell = worksheet.getRow(i).createCell(2);
			
			cell.setCellValue("Login pass,,,");
			fsIP.close();
			FileOutputStream output_file1 = new FileOutputStream(new File(
					"D:\\Workspace\\Final.automation\\ss.xlsx"));
			wb.write(output_file1);
			output_file1.close();
		}
	}
	}
/*
@Test (dependsOnMethods = { "update" })
	public void upload() throws Exception {
		// uploading a resume from external path
		/**
		 * @author karthiga balapriya work name : upload
		 */
	/*	File file = new File("D:\\Workspace\\TechFetch.Automation\\Locator.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]/a/img")).click();
		log.info("Clicking Replacedocs");

		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("replacedoccontentframe");
		Thread.sleep(1000);
		driver.findElement(By.id("resumeupload")).clear();
		driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("path"));
		log.info("Uploading Resume");

		Thread.sleep(10000);
		// WebElement Element =
		// driver.findElement(By.xpath(".//*[@id='dupupload2']/div/div/div"));
		// Element.sendKeys("C:\\hai.doc");
		driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		log.info("Clicking Submit button");

		Thread.sleep(3000);
		driver.findElement(By.id("btnClose")).click();
		log.info("Clicking Close button");

	}
@Test (dependsOnMethods = { "upload" })
	public void forward() throws Exception {
		// Displaying profile detail and downloading the resume
		/**
		 * @author Arun Sakthi work name : profile
		 */
		/*File file = new File("D:\\Workspace\\TechFetch.Automation\\Locator.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		Set<String> Wi = driver.getWindowHandles();
		System.out.println("No of Windows:" + Wi.size());
		Iterator it = Wi.iterator();
		// String main=(String) it.next();
		System.out.println(it.next());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[5]/a/img")).click();
		log.info("Clicking Profile");

		Wi = driver.getWindowHandles();
		log.info("No of Windows:" + Wi.size());

		System.out.println("No of Windows:" + Wi.size());
		it = Wi.iterator();
		it = Wi.iterator();
		String mmm = (String) it.next();
		String nnn = (String) it.next();
		System.out.println(mmm);
		System.out.println(nnn);
		driver.switchTo().window(nnn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(10000);

		driver.findElement(By.cssSelector("#download")).click();
		log.info("Downloading Profile");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='forward']")).click();
		log.info("Clicking Forward Button");

		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jsforwardprofilecontentframe");
		driver.findElement(By.xpath(".//*[@id='txtTo']")).sendKeys(prop.getProperty("mailid"));
		log.info("Entering Forward Mailid");

		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='btnsendmail']")).click();
		log.info("Clicking SendButton");

		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='btnPnlClose']")).click();
		log.info("Clicking CloseButton");

		driver.close();
		driver.switchTo().window(mmm);

	}



//for official
/*
@Test (dependsOnMethods = { "forward" })
	public void update() throws Exception {
		// creating a profile and perform edit and update
		/**
		 * @author surya Balapriya work name : myresume
		 */
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("contentframe");
		/*File file = new File("D:\\Workspace\\TechFetch.Automation\\Locator.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[2]/a")).click();
		log.info("Opening MyResume");

		driver.findElement(By.xpath(".//*[@id='addresumetab']")).click();
		log.info("Selecting AddResume");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='txtFName']")).sendKeys(prop.getProperty("firstname"));
		log.info("Entering FirstName");

		driver.findElement(By.xpath(".//*[@id='txtMName']")).sendKeys(prop.getProperty("middlename"));
		log.info("Entering MiddleName");

		driver.findElement(By.xpath(".//*[@id='txtLName']")).sendKeys(prop.getProperty("lastname"));
		log.info("Entering LastName");
		Thread.sleep(2000);
		Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='ddsCountry']")));
		log.info("Selecting Country");
		oSelect.selectByIndex(12);
		driver.findElement(By.xpath(".//*[@id='txtCity']")).sendKeys(prop.getProperty("city"));
		log.info("Entering City,state or zip");

		driver.findElement(By.xpath(".//*[@id='txtPhoneM']")).sendKeys(prop.getProperty("phone(mobile)"));
		log.info("Entering MobilePhone");

		driver.findElement(By.xpath(".//*[@id='txtPhoneA']")).sendKeys(prop.getProperty("phone(home)"));
		log.info("Entering HomePhone");

		driver.findElement(By.xpath(".//*[@id='txtPhoneW']")).sendKeys(prop.getProperty("phone(work)"));
		log.info("Entering WorkPhone");

		driver.findElement(By.xpath(".//*[@id='txtExtn']")).sendKeys(prop.getProperty("phoneextension"));
		log.info("Entering Extension");

		Select oSelect1 = new Select(driver.findElement(By.xpath(".//*[@id='ddlPreferredTime']")));
		oSelect1.selectByIndex(2);
		log.info("Selecting PrefferedTime");

		Select oSelect2 = new Select(driver.findElement(By.xpath(".//*[@id='ddlPhone']")));
		oSelect2.selectByIndex(2);
		log.info("Selecting Home");

		Select oSelect3 = new Select(driver.findElement(By.xpath(".//*[@id='ddsCitizen']")));
		oSelect3.selectByIndex(2);
		log.info("Selecting Citizen");

		driver.findElement(By.xpath(".//*[@id='chkWorkAuthorizationTNEAD']")).click();
		log.info("Clicking WorkAuthorization");

		Select oSelect4 = new Select(driver.findElement(By.xpath(".//*[@id='ddltneadlist']")));

		oSelect4.selectByIndex(2);
		log.info("Selecting NeedNewH1B");
		driver.findElement(By.id("resumeupload")).clear();
		log.info("clearing upload");
		driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("upload"));
		log.info("Selecting Resume");
		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		log.info("Clicking Submit button");
		Thread.sleep(100);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		log.info("Switching to Professional");
		Thread.sleep(1000);
		driver.findElement(By.id("rdBachelor")).click();
		log.info("Selecting Bachelor button on Highest degree");
		new Select(driver.findElement(By.id("ddlExpectedSalaryYear"))).selectByVisibleText("$10K");
		log.info("Selecting Expected salary per year");

		new Select(driver.findElement(By.id("ddlExpectedSalaryHour"))).selectByVisibleText("$15");
		log.info("Selecting Expected salary per hour");

		driver.findElement(By.id("txtJobTitle")).clear();
		driver.findElement(By.id("txtJobTitle")).sendKeys(prop.getProperty("jobtitle"));
		log.info("Entering job title");

		new Select(driver.findElement(By.id("ddsTotalExperience"))).selectByVisibleText("17");
		log.info("Selecting total experience");

		driver.findElement(By.cssSelector("option[value=\"17\"]")).click();
		log.info("Clicking Value ");

		new Select(driver.findElement(By.id("ddsUSAExperience"))).selectByVisibleText("15");
		log.info("Selecting USA experience");

		driver.findElement(By.id("txtResumeTitle")).clear();
		driver.findElement(By.id("txtResumeTitle")).sendKeys(prop.getProperty("resumetitle"));
		log.info("Entering resume title");

		driver.findElement(By.id("resumeupload")).clear();
		driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("uploadfile"));
		log.info("Uploading resume");
		Thread.sleep(10000);
		driver.findElement(By.id("btnProfessional")).click();
		log.info("Clicking save and next button");
		Thread.sleep(1000);

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("contentframe");

		// driver.findElement(By.linkText("*Skills(Incomplete)")).click();
		new Select(driver.findElement(By.id("ddlSpecializedArea"))).selectByVisibleText("Java, J2EE");
		log.info("Selecting specialized area");
		new Select(driver.findElement(By.id("ddlSpecializedSkill"))).selectByVisibleText("Java Front End");
		log.info("Selecting specialized skills");
		driver.findElement(By.id("txtSkill1")).clear();
		driver.findElement(By.id("txtSkill1")).sendKeys(prop.getProperty("skill"));
		log.info("Entering skill1");
		new Select(driver.findElement(By.id("ddlYears1"))).selectByVisibleText("2");
		log.info("Selecting years for skill1 ");
		driver.findElement(By.id("btnSkills")).click();
		log.info("Clicking save and next button");
		Thread.sleep(10000);
		// driver.findElement(By.id("Skillsli")).click();

		// driver.findElement(By.cssSelector("#Preferencesli > a")).click();
		driver.findElement(By.id("chkBusinessDomaintelecom")).click();
		log.info("Clicking preferred employment ");
		driver.findElement(By.id("radPublishToAll")).click();
		log.info("Selecting resume publishing options ");
		driver.findElement(By.id("chkprefjobyes")).click();
		log.info("Selecting domain experience");
		driver.findElement(By.id("btnPreferences")).click();
		log.info("Clicking save and next button");
		Thread.sleep(10000);
		driver.findElement(By.id("txtKeywords")).clear();
		driver.findElement(By.id("txtKeywords")).sendKeys(prop.getProperty("keyword"));
		log.info("Entering keywords ");
		driver.findElement(By.id("chkcontarctjobtype")).click();
		log.info("Clicking job type ");
		driver.findElement(By.id("contracttype")).click();
		driver.findElement(By.id("chkpermanentjobtype")).click();
		driver.findElement(By.id("txtJobwithtitle")).clear();
		driver.findElement(By.id("txtJobwithtitle")).sendKeys(prop.getProperty("title"));
		log.info("Entering job with title ");
		new Select(driver.findElement(By.id("ddlYears"))).selectByVisibleText("2");
		log.info("Selecting years");
		driver.findElement(By.cssSelector("#ddlYears > option[value=\"2\"]")).click();
		// new
		// Select(driver.findElement(By.id("lbPriorityList"))).selectByVisibleText("Florida
		// (FL)");
		// driver.findElement(By.xpath("//div[@onclick='javascript:
		// OptSelect();']")).click();
		// driver.findElement(By.xpath("//div[@onclick='javascript:
		// OptUnSelect();']")).click();
		driver.findElement(By.id("txtAlertName")).clear();
		driver.findElement(By.id("txtAlertName")).sendKeys(prop.getProperty("alert"));
		log.info("Entering alert name ");
		driver.findElement(By.id("btnJobAlert")).click();
		log.info("Clicking save and next button");
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[3]/a")).click();
	}*/






//for unofficial
@Test (dependsOnMethods ={ "Login" })
public void update() throws Exception {
	// creating a profile and perform edit and update
	/**
	 * @author surya Balapriya work name : myresume
	 */
	// driver.switchTo().defaultContent();
	// driver.switchTo().frame("contentframe");
	File file = new File("D:\\Workspace\\tech\\update.properties");
	FileInputStream fileInput;
	fileInput = new FileInputStream(file);
	Properties prop = new Properties();
	prop.load(fileInput);
	Logger log = Logger.getLogger("devpinoyLogger");
	Thread.sleep(1000);
	driver.findElement(By.xpath(prop.getProperty("MyResume"))).click();
	log.info("Opening MyResume");
Thread.sleep(1000);
	driver.findElement(By.xpath(prop.getProperty("AddResume"))).click();
	log.info("Selecting AddResume");

	driver.switchTo().defaultContent();
	driver.switchTo().frame("contentframe");

	Thread.sleep(1000);
	driver.findElement(By.xpath(prop.getProperty("Name1"))).sendKeys(
			prop.getProperty("firstname"));
	log.info("Entering FirstName");

	driver.findElement(By.xpath(prop.getProperty("Name2"))).sendKeys(
			prop.getProperty("middlename"));
	log.info("Entering MiddleName");
	driver.findElement(By.xpath(prop.getProperty("Name3"))).sendKeys(
			prop.getProperty("lastname"));
	log.info("Entering LastName");
	Thread.sleep(2000);
	Select oSelect = new Select(driver.findElement(By.xpath(prop
			.getProperty("Country"))));
	log.info("Selecting Country");
	oSelect.selectByIndex(12);
	driver.findElement(By.xpath(prop.getProperty("City"))).sendKeys(
			prop.getProperty("city"));
	log.info("Entering City,state or zip");

	driver.findElement(By.xpath(prop.getProperty("MobNo"))).sendKeys(
			prop.getProperty("phone(mobile)"));
	log.info("Entering MobilePhone");

	driver.findElement(By.xpath(prop.getProperty("HomeNo"))).sendKeys(
			prop.getProperty("phone(home)"));
	log.info("Entering HomePhone");
	driver.findElement(By.xpath(prop.getProperty("WorkNo"))).sendKeys(
			prop.getProperty("phone(work)"));
	log.info("Entering WorkPhone");
	driver.findElement(By.xpath(prop.getProperty("ExtensionNo"))).sendKeys(
			prop.getProperty("phoneextension"));
	log.info("Entering Extension");

	Select oSelect1 = new Select(driver.findElement(By.xpath(prop
			.getProperty("PrefferedTime"))));
	oSelect1.selectByIndex(2);
	log.info("Selecting PrefferedTime");

	Select oSelect2 = new Select(driver.findElement(By.xpath(prop
			.getProperty("Phone"))));
	oSelect2.selectByIndex(2);
	log.info("Selecting Home");

	Select oSelect3 = new Select(driver.findElement(By.xpath(prop
			.getProperty("Citizen"))));
	oSelect3.selectByIndex(2);
	log.info("Selecting Citizen");
	driver.findElement(By.xpath(prop.getProperty("WorkAuthorization")))
			.click();
	log.info("Clicking WorkAuthorization");

	Select oSelect4 = new Select(driver.findElement(By.xpath(prop
			.getProperty("NeedNewH1B"))));

	oSelect4.selectByIndex(2);
	log.info("Selecting NeedNewH1B");
	driver.findElement(By.id(prop.getProperty("Resumeupload"))).clear();
	log.info("clearing upload");
	driver.findElement(By.id(prop.getProperty("Resumeupload"))).sendKeys(
			prop.getProperty("upload"));
	;
	log.info("Selecting Resume");
	Thread.sleep(10000);

	driver.findElement(By.xpath(prop.getProperty("Submitt"))).click();
	log.info("Clicking Submit button");
	Thread.sleep(100);

	driver.switchTo().defaultContent();
	driver.switchTo().frame("contentframe");
	log.info("Switching to Professional");
	Thread.sleep(1000);
	driver.findElement(By.id(prop.getProperty("Bachelor"))).click();
	log.info("Selecting Bachelor button on Highest degree");
	Select oSelect5 = new Select(driver.findElement(By.id(prop
			.getProperty("ExcpectedSalary"))));
	oSelect5.selectByVisibleText("$10K");
	log.info("Selecting Expected salary per year");

	Select oSelect6 = new Select(driver.findElement(By.id(prop
			.getProperty("ExpectedSalaryHour"))));
	oSelect6.selectByVisibleText("$15");
	log.info("Selecting Expected salary per hour");

	driver.findElement(By.id(prop.getProperty("JobTitle"))).clear();
	driver.findElement(By.id(prop.getProperty("JobTitle"))).sendKeys(
			prop.getProperty("jobtitle"));
	log.info("Entering job title");

	Select oSelect7 = new Select(driver.findElement(By.id(prop
			.getProperty("TotalExperience"))));
	oSelect7.selectByVisibleText("17");
	log.info("Selecting total experience");

	driver.findElement(By.cssSelector(prop.getProperty("ExpValue")))
			.click();
	log.info("Clicking Value ");

	Select oSelect8 = new Select(driver.findElement(By.id(prop
			.getProperty("USAExperience"))));
	oSelect8.selectByVisibleText("15");
	log.info("Selecting USA experience");

	driver.findElement(By.id(prop.getProperty("ResumeTitle"))).clear();
	driver.findElement(By.id(prop.getProperty("ResumeTitle"))).sendKeys(
			prop.getProperty("resumetitle"));
	log.info("Entering resume title");

	driver.findElement(By.id(prop.getProperty("Resumeupload"))).clear();
	driver.findElement(By.id(prop.getProperty("Resumeupload"))).sendKeys(
			prop.getProperty("uploadfile"));
	log.info("Uploading resume");
	Thread.sleep(10000);
	driver.findElement(By.id(prop.getProperty("Professional"))).click();
	log.info("Clicking save and next button");
	Thread.sleep(1000);

	// driver.switchTo().defaultContent();
	// driver.switchTo().frame("contentframe");

	// driver.findElement(By.linkText("*Skills(Incomplete)")).click();
	Select oSelect9 = new Select(driver.findElement(By.id(prop
			.getProperty("SpecializedArea"))));
	oSelect9.selectByVisibleText("Java, J2EE");
	log.info("Selecting specialized area");
	Select oSelect10 = new Select(driver.findElement(By.id(prop
			.getProperty("SpecializedSkill"))));
	oSelect10.selectByVisibleText("Java Front End");
	log.info("Selecting specialized skills");
	driver.findElement(By.id(prop.getProperty("Skill1"))).clear();
	driver.findElement(By.id(prop.getProperty("Skill1"))).sendKeys(
			prop.getProperty("skill"));
	log.info("Entering skill1");
	Select oSelect11 = new Select(driver.findElement(By.id(prop
			.getProperty("Years1"))));
	oSelect11.selectByVisibleText("2");
	log.info("Selecting years for skill1 ");
	driver.findElement(By.id(prop.getProperty("Skills"))).click();
	log.info("Clicking save and next button");
	Thread.sleep(10000);
	// driver.findElement(By.id("Skillsli")).click();

	// driver.findElement(By.cssSelector("#Preferencesli > a")).click();
	driver.findElement(By.id(prop.getProperty("BusinessDomain"))).click();
	log.info("Clicking preferred employment ");
	driver.findElement(By.id(prop.getProperty("PublishToAll"))).click();
	log.info("Selecting resume publishing options ");
	driver.findElement(By.id(prop.getProperty("prefjob"))).click();
	log.info("Selecting domain experience");
	driver.findElement(By.id(prop.getProperty("Preferences"))).click();
	log.info("Clicking save and next button");
	Thread.sleep(10000);
	driver.findElement(By.id(prop.getProperty("Keywords"))).clear();
	driver.findElement(By.id(prop.getProperty("Keywords"))).sendKeys(
			prop.getProperty("keyword"));
	log.info("Entering keywords ");
	driver.findElement(By.id(prop.getProperty("Contarctjobtype"))).click();
	log.info("Clicking job type ");
	driver.findElement(By.id(prop.getProperty("Contracttype"))).click();
	driver.findElement(By.id(prop.getProperty("Permanentjobtype"))).click();
	driver.findElement(By.id(prop.getProperty("Jobwithtitle"))).clear();
	driver.findElement(By.id(prop.getProperty("Jobwithtitle"))).sendKeys(
			prop.getProperty("title"));
	log.info("Entering job with title ");
	Select oSelect12 = new Select(driver.findElement(By.id(prop
			.getProperty("Years"))));
	oSelect12.selectByVisibleText("2");
	log.info("Selecting years");
	driver.findElement(By.cssSelector(prop.getProperty("Yearvalue")))
			.click();
	;
	// new
	// Select(driver.findElement(By.id("lbPriorityList"))).selectByVisibleText("Florida
	// (FL)");
	// driver.findElement(By.xpath("//div[@onclick='javascript:
	// OptSelect();']")).click();
	// driver.findElement(By.xpath("//div[@onclick='javascript:
	// OptUnSelect();']")).click();
	driver.findElement(By.id(prop.getProperty("AlertName"))).clear();
	driver.findElement(By.id(prop.getProperty("AlertName"))).sendKeys(
			prop.getProperty("alert"));
	log.info("Entering alert name ");
	driver.findElement(By.id(prop.getProperty("JobAlert"))).click();
	log.info("Clicking save and next button");
	driver.switchTo().defaultContent();
	Thread.sleep(1000);
	driver.findElement(By.xpath(prop.getProperty("Myjobsbutton"))).click();
}



/*
@Test (dependsOnMethods = { "update" })
	public void fetch() throws Exception {
		// fetching the job based on resume detail
		/**
		 * @author Durga work name : myjob
		 */
/*File file = new File("D:\\Workspace\\TechFetch.Automation\\Locator.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[3]/a")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[3]/a")).click();
		log.info("clicking the my jobs tab");

		driver.findElement(By.id("fetchjobstab")).click();
		log.info("clicking fetch job tab");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		log.info("move to content frame");
		driver.findElement(By.id("txtKeyword")).clear();
		driver.findElement(By.id("txtKeyword")).sendKeys(prop.getProperty("keywords"));
		log.info("Entering the keyword");
		driver.findElement(By.id("rbKeywordsAll")).click();
		log.info("select the type");
		new Select(driver.findElement(By.id("ddlCountry"))).selectByVisibleText("India");
		log.info("select the country");
		new Select(driver.findElement(By.id("ddlSpecializedArea"))).selectByVisibleText("Java, J2EE");
		log.info("select the specialized skills");
		driver.findElement(By.id("li1")).click();
		log.info("click the browse button");
		Thread.sleep(1000);
		driver.findElement(By.id("txtcity")).clear();
		driver.findElement(By.id("txtcity")).sendKeys(prop.getProperty("cityname"));
		log.info("select the state");
		Thread.sleep(1000);
		// Alert A3 = driver.switchTo().alert();
		// A3.accept();
		// driver.findElement(By.cssSelector("i.fa.fa-forward")).click();
		// driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
		// driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
		// driver.findElement(By.id("chkRemote")).click();
		// driver.findElement(By.cssSelector("i.fa.fa-forward")).click();
		// driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
		// driver.findElement(By.cssSelector("i.fa.fa-backward")).click();
		driver.findElement(By.id("chkPreferredEmployment_5")).click();
		log.info("Clicking prefered employment");
		driver.findElement(By.id("chkWorkAuthorization_1")).click();
		log.info("Clicking the work authorization");
		driver.findElement(By.id("chkWorkAuthorization_5")).click();
		log.info("Clicking the work authorization");
		driver.findElement(By.id("chkWorkAuthorization_5")).click();
		log.info("Clicking the work authorization");
		driver.findElement(By.id("chkWorkAuthorization_4")).click();
		log.info("Clicking the work authorization");
		driver.findElement(By.id("chkWorkAuthorization_3")).click();

		log.info("Clicking the work authorization");
		driver.findElement(By.id("chkWorkAuthorization_2")).click();
		log.info("Clicking the work authorization");
		driver.findElement(By.id("chkWorkAuthorization_1")).click();
		log.info("Clicking the work authorization");
		driver.findElement(By.id("chkRemote")).click();

		driver.findElement(By.id("chkRemote")).click();
		log.info("Clickingthe check remote option");
		driver.findElement(By.id("txtExcludeWords")).clear();

		driver.findElement(By.id("txtExcludeWords")).sendKeys(prop.getProperty("excludekeyword"));
		log.info("Clicking the exclude words");
		new Select(driver.findElement(By.id("ddlJobPost"))).selectByVisibleText("2 Days");
		log.info("Selecting a job within a days/months/years");
		driver.findElement(By.id("btnFetchJobs")).click();
		log.info("Clicking a fetch job button");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[4]/a[1]")).click();
		log.info("Clicking JobAlert menu ");
		// driver.switchTo().frame("contentframe");
		// driver.findElement(By.id(".//*[@id='page-container']/div/div/div/div/div[1]")).click();

	}
@Test (dependsOnMethods = { "fetch" })
	public void listing() throws Exception {
		// creating job alert and alert list.
		/**
		 * @author sans work name : jobalert
		 */
/*File file = new File("D:\\Workspace\\TechFetch.Automation\\Locator.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[4]/a[1]")).click();
		// driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[4]/a[1]")).click();
		driver.findElement(By.xpath(".//*[@id='createjobalerttab']")).click();
		log.info("Clicking Create jobalert ");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='ddlProfile']")));
		log.info("Selecting profile ");
		oSelect.selectByIndex(5);
		driver.findElement(By.xpath(".//*[@id='txtExclucompname']")).sendKeys(prop.getProperty("excludecompanyname"));
		log.info("Entering exclude company name");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='txtAlertName']")).sendKeys(prop.getProperty("alertname"));

		driver.findElement(By.xpath(".//*[@id='btnSaveAlert']")).click();
		log.info("Clicking save alert");
		// Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// alert list
		driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[4]/a[1]")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath(".//*[@id='alertlisttab']")).click();
		log.info("Clicking alertlist");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		Select oselect = new Select(driver.findElement(By.xpath(".//*[@id='consstatus-filter']")));
		oselect.selectByIndex(0);
		Select oselect1 = new Select(driver.findElement(By.xpath(".//*[@id='insstatus-filter']")));
		oselect1.selectByIndex(0);
		Thread.sleep(1000);
		// delete alert
		driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/tbody/tr[2]/td[7]/a/img")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		// back to alert for matched jobs
		/*
		 * driver.switchTo().defaultContent();
		 * driver.findElement(By.xpath(".//*[@id='alertlist']")).click();
		 * Thread.sleep(2000); driver.switchTo().defaultContent();
		 * driver.switchTo().frame("contentframe"); Select oselect2 = new
		 * Select(driver.findElement(By.xpath(".//*[@id='consstatus-filter']")));
		 * oselect2.selectByIndex(0); Select oselect3 = new
		 * Select(driver.findElement(By.xpath(".//*[@id='insstatus-filter']")));
		 * oselect3.selectByIndex(0); //matched jobs driver.findElement(By.xpath(
		 * ".//*[@id='tblouterdiv']/table/tbody/tr[2]/td[6]/a")).click();
		 * driver.switchTo().defaultContent(); driver.switchTo().frame("contentframe");
		 * Thread.sleep(2000);
		 */
		/*
		 * driver.findElement(By.xpath(".//*[@id='ctl06_lnkLogin']")).click();
		 * driver.switchTo().defaultContent();
		 * driver.switchTo().frame("applyemailframe"); //
		 * driver.findElement(By.xpath(".//*[@id='txtCC']")).sendKeys(
		 * "trainee6@tiliconveli.com"); //
		 * driver.findElement(By.xpath(".//*[@id='fileCL']"));
		 * driver.findElement(By.xpath(".//*[@id='fileCL']")).click();
		 */
	/*	driver.switchTo().defaultContent();

	}
@Test (dependsOnMethods = { "listing" })
	public void features() throws Exception {
		// showing the result based on resume
		/**
		 * @author Ram Sastha work name : features
		 */
	/*	driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a")).click();
		log.info("Clicking Features button");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='demandindextab']")).click();
		log.info("Clicking Demand index button");
		Thread.sleep(2000);
		driver.switchTo().frame("contentframe");
		driver.findElement(By.xpath(".//*[@id='ddlprofile']")).click();
		log.info("Clicking Profilebutton");
		Select select = new Select(driver.findElement(By.id("ddlprofile")));
		List<WebElement> l = select.getOptions();

		Select select1 = new Select(driver.findElement(By.xpath(".//*[@id='ddlspecializedarea']")));
		List<WebElement> l1 = select1.getOptions();

		Select select2 = new Select(driver.findElement(By.xpath(".//*[@id='ddlmonthyear']")));

		Select select3 = new Select(driver.findElement(By.xpath(".//*[@id='ddlstate']")));

		for (int i = 0; i < 1; i++) {
			select.selectByIndex(i);
			for (int i1 = 0; i1 < 1; i1++) {
				select1.selectByIndex(i1);
				for (int i2 = 0; i2 < 1; i2++) {
					select2.selectByIndex(i2);

					for (int i3 = 0; i3 < 1; i3++) {

						select3.selectByVisibleText("CA");
						driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
						Thread.sleep(5000);
						select3.selectByVisibleText("FL");
						driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
						Thread.sleep(5000);
						select3.selectByVisibleText("SC");
						driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
						Thread.sleep(5000);
					}
				}
			}
		}

	}*/
@Test (dependsOnMethods = { "update" })
	public void logout() throws Exception {
		// performing logout
		/**
		 * @author karthiga work name: logout
		 * 
		 */
		driver.switchTo().defaultContent();

		Thread.sleep(10000);

		// Logout...
		driver.findElement(By.xpath(".//*[@id='drop7']/img")).click();
		log.info("Clicking user settings ");
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='mini-nav']/li/ul/li[4]/div/input")).click();
		log.info("Clicking logout button ");
		Thread.sleep(10000);
	}
	}
/*@Test
	public void finish() throws Exception {
		// performing overall action
		/**
		 * @author selva venkat work name : final
		 
		login();
		upload();
		forward();
		update();
		fetch();
		listing();
		features();
		logout();
	}*/
