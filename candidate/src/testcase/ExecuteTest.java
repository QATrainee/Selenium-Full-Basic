package testcase;

import java.io.IOException;
import java.util.Properties;

import operation.ReadObject;
import operation.UiOperation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import excel.ReadExcel;
public class ExecuteTest {
	public static void main(String args[]) throws Exception
	{WebDriver driver;
    
        // TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jarfiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://uat.techfetch.com");
ReadExcel file = new ReadExcel();
ReadObject object = new ReadObject();
Properties allObjects = object.getObjectRepository();
UiOperation operation = new UiOperation(driver);

//Read keyword sheet
Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir")+"\\","re.xlsx" , "Sheet1");
//Find number of rows in excel file
    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
    

    
    for (int i = 0; i < rowCount+1; i++) {
        //Loop over all the rows
        Row row = guru99Sheet.getRow(i);
        System.out.println(row.getCell(0).toString()+"----"+ row.getCell(1).toString()+"----"+
                row.getCell(2).toString()+"----"+ row.getCell(3).toString());
            //Call perform function to perform operation on UI
                operation.perform(allObjects, row.getCell(0).toString(), row.getCell(1).toString(),
                    row.getCell(2).toString(), row.getCell(3).toString());
        
    }
    
}
}
