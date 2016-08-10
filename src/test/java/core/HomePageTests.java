package core;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HomePageTests {
	//Webdriver driver = new;
	
public HomePage hp = new HomePage();	
	public HomePage_JsonConstructor jConstractor = new HomePage_JsonConstructor();
	
  @Test
  public void titleValidatin() {
	  String title = hp.getPageTitle();
	  Assert.assertEquals(title, hp.homeTitle_exp);
  }
  
 
  @Test
  public void createJsonDataFile(){
	  jConstractor.createJsonFile(hp.driver);  
  }
  
  @BeforeTest
  public void beforeTest() {
	  hp.readProperties("./src/test/resources/CommonDataSourse.properties");
	  hp.beforeTestCase();
  }

  @AfterTest
  public void afterTest() {
	 hp.afterTestCase();
  }

}
