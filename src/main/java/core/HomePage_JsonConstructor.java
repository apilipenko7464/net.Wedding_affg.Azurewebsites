package core;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
//import java.util.Properties;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import org.openqa.selenium.*;
import core.ElementsObjectModel;

public class HomePage_JsonConstructor {

    public   ArrayList<ElementsObjectModel> alCPE = null;
   
    public String [] el_locator  = {
 		   "/html/body/div/header/a",
 		   "//a[1]",
 		   "//a[2]",
 		   "//*[@name='Email']",
 		   "//*[@name='Password']",
 		   "//*[@type='submit']"
    };

 
  /*    
    public String [] el_locator  = {
  		   el1, el2, el3, el4, el5, el6
     };   
 

    
   public static String el1 = null;
   public static String el2 = null; 
   public static String el3 = null;
   public static String el4 = null;
   public static String el5 = null;
   public static String el6 = null;
   
 String	file_path = "./src/test/resources/HomePageElementsLocators.properties";
   public void readProperties (String file_path){

	  
   try {
	Properties property = new Properties();
	property.load(new FileInputStream(file_path));
	
	el1 = property.getProperty("el1");		
	el2 = property.getProperty("el2");	
	el3 = property.getProperty("el3");	
	el4 = property.getProperty("el4");	
	el5 = property.getProperty("el5");	
	el6 = property.getProperty("el6");	
			
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
   
 */  
   
  public   String jsonPath = "/Users/anna/Workspace/net.Wedding_affg.Azurewebsites/src/test/resources/";
  public   String jsonFile = "HomePage.json";  
  public   String fullTestPath = "/Users/anna/Workspace/net.Wedding_affg.Azurewebsites/src/test/resources/HomePage.json";
  
    
    public  void createJsonFile(WebDriver driver){

        ElementsObjectModel elObj ;
        alCPE = new ArrayList<ElementsObjectModel>();
        JsonGenerator jg = openJsonGenerator(jsonFile,jsonPath);
        jg.writeStartArray();
        
        for (int i = 0; i < this.el_locator.length; i++) {
        	elObj = readElementProperty(driver, this.el_locator[i]); //for each web-element creating single instance of  Object
            alCPE.add(elObj);                                // adding Object as element to the ArrayList
            elObj.printMpe();                                //printing out data of each Object
            addJsonBlock(jg, elObj);
        }
        
        jg.writeEnd(); // end of Json array
        jg.close();    // close Json generator      
    }
    
    public  JsonGenerator openJsonGenerator(String file, String path) {
        JsonGenerator jg = null;
        try {
            if ((file == null) || (path == null)) {return null;}
            String fullPath = path + "//" + file;
            jg = Json.createGenerator(new FileWriter(fullPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jg;
     }  
    
    public  void addJsonBlock(JsonGenerator adj, ElementsObjectModel elObj ) {

        try {
            //StringWriter w = new StringWriter();
            adj.writeStartObject();

            adj.write("locator",elObj.locator);
            adj.write("isPresent",elObj.isPresent);
            adj.write("isDisplayed",elObj.isDisplayed);
            adj.write("isEnabled",elObj.isEnabled);
            adj.write("location_X",elObj.location_X);
            adj.write("location_Y",elObj.location_Y);
            adj.write("sizeWidth",elObj.sizeWidth);
            adj.write("sizeHeight",elObj.sizeHeight);
            adj.writeEnd();

        } catch (Exception e) {
                e.printStackTrace();
        }
    }
       
    public  ElementsObjectModel readElementProperty (WebDriver driver, String locator) {
        ElementsObjectModel elObj = new ElementsObjectModel();
        try {
     	   elObj.locator = locator;
     	   elObj.isPresent = driver.findElements(By.xpath(locator)).size() >= 0;
     	   elObj.isDisplayed =  driver.findElement(By.xpath(locator)).isDisplayed();
     	   elObj.isEnabled =  driver.findElement(By.xpath(locator)).isEnabled();
     	   Point Location = driver.findElement(By.xpath(locator)).getLocation();
     	   elObj.location_X = Location.getX();
     	   elObj.location_Y = Location.getY();
           Dimension el_Size = driver.findElement(By.xpath(locator)).getSize();
           elObj.sizeWidth = el_Size.getWidth();
           elObj.sizeHeight = el_Size.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elObj;
    }
    
      
}
