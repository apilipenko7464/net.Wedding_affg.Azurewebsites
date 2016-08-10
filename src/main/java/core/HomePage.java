package core;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage {

	public  WebDriver driver ;

	
	public  String url = null;
	public String homeTitle_exp = null;
    public String jsonPathCom = null;

public void readProperties (String file_path){
	    	// String	file_path = "./src/test/resources/CommonDataSourse.properties";	
	    try {
		Properties property = new Properties();
		property.load(new FileInputStream(file_path));
		
		jsonPathCom = property.getProperty("jsonPathCom");		
		url = property.getProperty("url");
		homeTitle_exp = property.getProperty("homeTitle_exp");
				
			} catch (FileNotFoundException e) {
				System.out.println("Method 'readProperties()' - BLOCK");
				System.out.println();
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println("Method 'readProperties()' - BLOCK");
				System.out.println();
				System.out.println(e.getMessage());
			}	

	}//END readProperties	
	

 
	
    public  void beforeTestCase(){   	
    	driver   = new FirefoxDriver();
    	driver.get(url);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 	   
    }
       
    public  void afterTestCase() {
    	driver.quit();
    }
    
    public  String getPageTitle(){    	
    	String homeTitle_act = driver.getTitle();    	
    	 	System.out.println(homeTitle_act);
			return homeTitle_act;
    }

    
    
    
    
    
    public   Dimension get_element_Dimension( String locator) {
        Dimension el_Size = driver.findElement(By.xpath(locator)).getSize();   
        System.out.println("Size W:" + el_Size.getWidth()  );
        System.out.println("Size H:" + el_Size.getHeight()  );
        return el_Size;
    }

    public   Point get_element_Location( String locator) {
            Point el_Location = driver.findElement(By.xpath(locator)).getLocation();
            System.out.println("Location X:" + el_Location.getX()  );
            System.out.println("Location Y:" + el_Location.getY()  );
            return el_Location;

    }

    public   boolean element_isEnabled( String locator) {
        boolean el_isEnabled = driver.findElement(By.xpath(locator)).isEnabled();
        System.out.println("el_isEnabled: " + el_isEnabled);
        return el_isEnabled;
    }

    public boolean element_isDisplayed(String locator ) {
            boolean el_isDisplayed = driver.findElement(By.xpath(locator)).isDisplayed();    
            System.out.println("element_isDisplayed: " +el_isDisplayed );
            return el_isDisplayed;
        }

    public boolean element_isPresent( String locator) {
        boolean isPresent;

        try {
            isPresent= driver.findElements(By.xpath(locator)).size() >= 0;
            System.out.println("element isPresent: " + isPresent);
            return isPresent;

        } catch ( NoSuchElementException e ) {
            isPresent= driver.findElements(By.xpath(locator)).size() > 0;
            System.out.println("NoSuchElement");
            
        }
        return isPresent;
    }    
    
    
    
    
}//main class
