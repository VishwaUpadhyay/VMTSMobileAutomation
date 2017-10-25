package com.org.vm;

	import java.net.URL;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	//@TestObject(testObjectApiKey = "C5734DB513204E3588440085869A9B8B"/*, testObjectSuiteId = 12345*/)
	//@RunWith(TestObjectAppiumSuite.class)
	public class TVAJUnitTest {
		private static final String INTIAL_TITLE= "Unsupported Browser - Virgin TV Anywhere - Virgin Media";
		private static final String JavascriptExecutor = null;
	    //public WebDriver driver = null;
	    //public AppiumDriver driver = null;
	    public RemoteWebDriver driver = null;
	    
	    private static Logger log = Logger.getLogger(TVAJUnitTest.class);
	    
	    @Rule
	    public TestName testName = new TestName();

	   // @Rule
	    //public TestObjectTestResultWatcher resultWatcher = new TestObjectTestResultWatcher();
	    
	    @Before
	    public void setUp() throws Exception {
	   
	    	System.out.println("Executing VM Kids application setup");
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        System.out.println("Start adding capabilities");
	        capabilities.setCapability("testobject_api_key", "787C8B6E4F90422C84AA28F26FEEEB76");
	        //capabilities.setCapability("testobject_test_report_id", resultWatcher.getTestReportId());
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("testobject_device", "Motorola_Moto_E_2nd_gen_free");
	        capabilities.setCapability("appiumVersion","1.7.1");
	        capabilities.setCapability("testobject_suite_name","TV Anywhere Suite");
	        capabilities.setCapability("testobject_test_name ","Verify TV Anywhere Login");
	        //capabilities.setCapability("phoneOnly", "false");
	        //capabilities.setCapability("tabletOnly", "false");
	        //capabilities.setCapability("privateDevicesOnly", "false");
	        //capabilities.setCapability("app","Chrome");
	        //driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities);
	        //driver = new AndroidDriver(new URL("https://us1.appium.testobject.com/wd/hub"), capabilities);
	        System.out.println("Creating driver/Allocating device........");
	        driver = new RemoteWebDriver(new URL("https://eu1.appium.testobject.com/wd/hub"), capabilities);
	        //driver = new AndroidDriver<WebElement>(new URL("https://eu1.appium.testobject.com/wd/hub"), capabilities);
	       // webDriver = (RemoteWebDriver)driver;
	      //  resultWatcher.setAppiumDriver(driver);
	        System.out.println("driver created launching the app........");
	        //driver.launchApp();
	        System.out.println("App lunched");
	        driver.get("http://anywhere.virginmedia.com/");
	        log.info(testName.getMethodName() + " STARTING - Live view: " + driver.getCapabilities().getCapability("testobject_test_live_view_url"));
	        System.out.println("Setup Complete....");
	    }
	    
	    
	    
		@After
		public void tearDown() {
			// The watcher will take care of quitting the driver.
			if (driver != null) {
				driver.quit();
			}
		}
		
		@org.junit.Test
	    public void verifyScreenOrientation() throws InterruptedException {
			System.out.println("Test started....");
			String title  = driver.getTitle();
			System.out.println(title);
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement we = driver.findElement(By.linkText("Sign in"));
			wait.until(ExpectedConditions.elementToBeClickable(we));
			if(title.equals(INTIAL_TITLE)) {
				we.click();
			    //if(we != null) we;
			   // else System.out.println("Element not found");
			}
			    	
			System.out.println(driver.getTitle());
//			driver.getScreenshotAs(OutputType.FILE);
//			assertEquals(ScreenOrientation.LANDSCAPE, driver.getOrientation());
//			System.out.println("Test ended....");
	    }	
	}
