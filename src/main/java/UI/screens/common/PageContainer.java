package UI.screens.common;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


/**
 * @author Madhu Anjanappa
 *
 */
public class PageContainer {

	public AndroidDriver driver;

	
	public PageContainer(AndroidDriver driver) {
		this.driver = driver;
	}

}
