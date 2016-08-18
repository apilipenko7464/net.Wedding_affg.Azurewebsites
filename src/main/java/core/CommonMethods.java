package core;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CommonMethods {

	public  WebDriver driver ;

	
	public  String url = null;
	public String homeTitle_exp = null;
    String jsonPathHome = null;

public void readProperties (String file_path){
	    	// String	file_path = "./src/test/resources/CommonDataSourse.properties";	
	    try {
		Properties property = new Properties();
		property.load(new FileInputStream(file_path));
		
		jsonPathHome = property.getProperty("jsonPathHome");		
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
	

 
	
    public  void before(){   	
    	driver   = new FirefoxDriver();
    	driver.get(url);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 	   
    }
       
    public  void after() {
    	driver.quit();
    	
    }
    
    public  String getPageTitle(){    	
    	String homeTitle_act = driver.getTitle();    	
    	 	System.out.println(homeTitle_act);
			return homeTitle_act;
    }

    
//creating ArrayList collection where every element has data type custom object ElementsObjectModel
	
    
    public ArrayList<ElementsObjectModel> ALeom = new ArrayList<ElementsObjectModel>();
    
    public void loadTestData(String path){
	     Long tmp = 0L;
	     JSONParser parser = new JSONParser();
	      int i = 0;
	      ElementsObjectModel elParamBlock = null;       //  elParamBlock  = Block of element parameters
	    try {
	    	    	
	        //1.  
	    	
	        JSONArray a = (JSONArray) parser.parse(new FileReader(path));
	       
	        //2. every element of Array "a" is object "o" of Object type 
	        for (Object o : a)
	        {
	        	
	      	//3. initialization of class ElementsObjectModel inside method
	        	elParamBlock = new ElementsObjectModel();   //inicialization of class
	      
	        //4. here is casting data from javas' datatype Object to JSONObject	
	        	JSONObject elements= (JSONObject) o;
	        	
            //5. Copy value from JSONObject to custom object   ElementsObjectModel
	        	elParamBlock.locator = (String) elements.get("locator");                    
	        	elParamBlock.isPresent = (Boolean) elements.get("isPresent");            
	        	elParamBlock.isDisplayed = (Boolean) elements.get("isDisplayed");         
	        	elParamBlock.isEnabled = (Boolean) elements.get("isEnabled");   
	            tmp = (Long)elements.get("location_X");  //casting Long to int 
	            elParamBlock.location_X = tmp.intValue();   
	            tmp = (Long)elements.get("location_Y"); 
	            elParamBlock.location_Y = tmp.intValue();      
	            tmp = (Long)elements.get("sizeWidth"); 
	            elParamBlock.sizeWidth = tmp.intValue();   
	            tmp = (Long)elements.get("sizeHeight");
	            elParamBlock.sizeHeight = tmp.intValue();

	            ALeom.add(elParamBlock);
	            
                System.out.println("collection element #" + i + ": " + ALeom.get(i).locator);
                i++;
	        }


	    } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); System.out.println(elParamBlock.locator);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); System.out.println(elParamBlock.locator);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); System.out.println(elParamBlock.locator);}
        }
 
    
    
    public  Dimension get_element_Dimension( String locator) {
        Dimension el_Size = driver.findElement(By.xpath(locator)).getSize();    
        return el_Size;
    }

    public  Point get_element_Location( String locator) {
            Point el_Location = driver.findElement(By.xpath(locator)).getLocation();
            return el_Location;

    }

    public  boolean element_isEnabled( String locator) {
        boolean el_isEnabled = driver.findElement(By.xpath(locator)).isEnabled();
        return el_isEnabled;
    }

    public  boolean element_isDisplayed(String locator ) {
            boolean el_isDisplayed = driver.findElement(By.xpath(locator)).isDisplayed();        
            return el_isDisplayed;
        }


    public  boolean element_isPresent( String locator) {
        boolean isPresent;

        try {
            isPresent= driver.findElements(By.xpath(locator)).size() >= 0;
            return isPresent;

        } catch ( NoSuchElementException e ) {
            isPresent= driver.findElements(By.xpath(locator)).size() > 0;
            
        }
        return isPresent;
    }

    
    
}//main class
