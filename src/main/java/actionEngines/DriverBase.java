package actionEngines;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import UI.screens.common.PageContainer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import utilities.Logger;


/**
 * @author Madhu Anjanappa 
 *
 */
public class DriverBase {

	protected static AppiumDriver driver;
	protected String env,device;
	public PageContainer container;
	public static TouchAction tapOn;
	public static Actions action;
	
	/**
	 * Method to maximize the screen
	 */
	public static void maximize() {
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point position = new Point(0, 0);
		driver.manage().window().setPosition(position);
		Dimension maximizedScreenSize = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
		driver.manage().window().setSize(maximizedScreenSize);
		driver.manage().window().maximize();

	}
	
	/** Method to get the driver
	 * 
	 * @return the driver
	 */
	public static WebDriver getDriver() {
		if (driver == null)
			throw new RuntimeException("We have not instantiated the driver.");
		return driver;
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult)
			throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			try {
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(getImagePath(testResult)));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private String getImagePath(ITestResult testResult) {

		String path = System.getProperty("user.dir") + File.separator
				+ "test-output" + File.separator + "images";
		File filePath = new File(path);
		filePath.mkdirs();

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date(testResult.getEndMillis()));
		String filePathName = filePath.getAbsolutePath() + File.separator
				+ testResult.getName() + timeStamp + ".png";
		return filePathName;
	}

//	@AfterClass(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}
	
	/**
	 * Method to close the app 
	 */
	public void closeApp(){
		driver.closeApp();
	}
	
	
	/** Method to launch the app
	 * 
	 * @throws Exception
	 */
	public void launchApp() throws Exception {
		driver.launchApp();
	}

	
	/** Method to run the driver with desired capabilities
	 * 
	 * @param device Emulator/device
	 * @return Object of desired capabilities
	 * 
	 * @throws Exception
	 */
	public DesiredCapabilities installedAppCaps(String device) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (device == "emulator") 
        {
        	//not implemented yet
        }else  if (device == "device") {
        	capabilities.setCapability("VERSION", "5.0.1");
			capabilities.setCapability("device", "Android");
			capabilities.setCapability("deviceName", "dc14aaa1");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", "E:\\AppiumProject\\maven\\src\\test\\resources\\FlixBus.apk");
			capabilities.setCapability("appPackage", "de.flixbus.app");
			capabilities.setCapability("appActivity", "de.meinfernbus.Main");
		}
        return capabilities;
    }
	
	
	/** Method to launch the app with new desired capabilities.
	 *  
	 * @param env - Android/ios
	 * @param device - Emulator/Phone
	 * @throws Exception
	 */
	public void LaunchApp(String env, String device) throws Exception {
		
		if(env.equals("Android")) 
		{	
			try {
				Logger.log("Launching app.....with desired capability...");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), installedAppCaps(device));
				 
			}catch(WebDriverException e) {
				throw new Exception ("Appium server not started");
			}

			// Initiate page driver, to initiates all page objects
			tapOn= new TouchAction(driver);
			action = new Actions(driver);
			container = new PageContainer((AndroidDriver) driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Logger.log("Driver launched successfully!");
			
		}else if(env=="ios") 
		{
			//not implemented yet
		}
	}
}
