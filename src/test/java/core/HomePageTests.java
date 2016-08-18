package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class HomePageTests {
	
	
public CommonMethods cm = new CommonMethods();	
	public HomePage_JsonConstructor jConstractor = new HomePage_JsonConstructor();
	

  @Test
  public void test_0101titleValidatin() {
	  String title = cm.getPageTitle();
	  Assert.assertEquals(title, cm.homeTitle_exp);
  }
   
  @Test (enabled = false)   //(enabled = false)
  public void createJsonDataFile(){
	  jConstractor.createJsonFile(cm.driver);  
  }
 
 
  @Test
  public void test_0201_RegisterLink_validation () {
          
              ElementsObjectModel elParamBlock = cm.ALeom.get(0);
  	  Assert.assertEquals((boolean)cm.element_isDisplayed(elParamBlock.locator), (boolean)elParamBlock.isDisplayed);
  	  Assert.assertEquals((boolean)cm.element_isEnabled(elParamBlock.locator), (boolean)elParamBlock.isEnabled);
  	  Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getX(), (int)elParamBlock.location_X);
  	  Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getY(), (int)elParamBlock.location_Y);
  	  Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getWidth(), (int)elParamBlock.sizeWidth);
  	  Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getHeight(), (int)elParamBlock.sizeHeight);
    }
    
  @Test
  public void test_0202_Facebook_landing_btn_validation () {
           
              ElementsObjectModel elParamBlock = cm.ALeom.get(1);
  	  Assert.assertEquals((boolean)cm.element_isDisplayed(elParamBlock.locator), (boolean)elParamBlock.isDisplayed);
  	  Assert.assertEquals((boolean)cm.element_isEnabled(elParamBlock.locator), (boolean)elParamBlock.isEnabled);
  	  Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getX(), (int)elParamBlock.location_X);
  	  Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getY(), (int)elParamBlock.location_Y);
  	  Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getWidth(), (int)elParamBlock.sizeWidth);
  	  Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getHeight(), (int)elParamBlock.sizeHeight);
  }
  
  @Test
  public void test_0203_Google_landing_btn_validation () {
  	       
  	              ElementsObjectModel elParamBlock = cm.ALeom.get(2);
  	   Assert.assertEquals((boolean)cm.element_isDisplayed(elParamBlock.locator), (boolean)elParamBlock.isDisplayed);
  	   Assert.assertEquals((boolean)cm.element_isEnabled(elParamBlock.locator), (boolean)elParamBlock.isEnabled);
  	   Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getX(), (int)elParamBlock.location_X);
  	   Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getY(), (int)elParamBlock.location_Y);
  	   Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getWidth(), (int)elParamBlock.sizeWidth);
  	   Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getHeight(), (int)elParamBlock.sizeHeight);
  	  }
  	  	  
  @Test
  public void test_0204_InputField_Email_validation () {
  	   
  	                ElementsObjectModel elParamBlock = cm.ALeom.get(3);
  	    Assert.assertEquals((boolean)cm.element_isDisplayed(elParamBlock.locator), (boolean)elParamBlock.isDisplayed);
  	    Assert.assertEquals((boolean)cm.element_isEnabled(elParamBlock.locator), (boolean)elParamBlock.isEnabled);
  	    Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getX(), (int)elParamBlock.location_X);
  	    Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getY(), (int)elParamBlock.location_Y);
  	    Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getWidth(), (int)elParamBlock.sizeWidth);
  	    Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getHeight(), (int)elParamBlock.sizeHeight);
  	    	  
  	    }
  
  @Test
  public void test_0205_InputField_Password_validation () {
  	    
  	                ElementsObjectModel elParamBlock = cm.ALeom.get(4);
  	     Assert.assertEquals((boolean)cm.element_isDisplayed(elParamBlock.locator), (boolean)elParamBlock.isDisplayed);
  	     Assert.assertEquals((boolean)cm.element_isEnabled(elParamBlock.locator), (boolean)elParamBlock.isEnabled);
  	     Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getX(), (int)elParamBlock.location_X);
  	     Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getY(), (int)elParamBlock.location_Y);
  	     Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getWidth(), (int)elParamBlock.sizeWidth);
  	     Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getHeight(), (int)elParamBlock.sizeHeight);
  	    	  
  	    }
  	    
  @Test
  public void test_0206_Landing_btn_Submit_validation () {
  	          
  	                ElementsObjectModel elParamBlock = cm.ALeom.get(5);
  	      Assert.assertEquals((boolean)cm.element_isDisplayed(elParamBlock.locator), (boolean)elParamBlock.isDisplayed);
  	      Assert.assertEquals((boolean)cm.element_isEnabled(elParamBlock.locator), (boolean)elParamBlock.isEnabled);
  	      Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getX(), (int)elParamBlock.location_X);
  	      Assert.assertEquals((int)cm.get_element_Location(elParamBlock.locator).getY(), (int)elParamBlock.location_Y);
  	      Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getWidth(), (int)elParamBlock.sizeWidth);
  	      Assert.assertEquals((int)cm.get_element_Dimension(elParamBlock.locator).getHeight(), (int)elParamBlock.sizeHeight);
  	    	  
  	    }

  	    
  
  @BeforeClass
  public void beforeClass(){
	  cm.before();

  }
  
  @BeforeTest
  public void beforeTest() {	
	  cm.readProperties("./src/test/resources/CommonDataSourse.properties");
	  cm.loadTestData(cm.jsonPathHome ); 
  }

  @AfterClass
  public void afterCLass() {
	  cm.after();
  }

}
