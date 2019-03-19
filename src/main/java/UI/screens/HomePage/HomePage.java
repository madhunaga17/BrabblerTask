package UI.screens.HomePage;

import org.testng.Assert;

import UI.screens.common.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends PageBase{


	public HomePage(AppiumDriver driver) {
		super((AndroidDriver) driver);
	}

	/*
	 * ========================================================================
	 * 							Locators
	 * ========================================================================
	 */
	

	@AndroidFindBy(id= "de.flixbus.app:id/actv_from")
	private MobileElement homePage_departure_dropDown_list;
	
	@AndroidFindBy(id= "de.flixbus.app:id/asp_search_input")
	private MobileElement departure_textfield;
	
	@AndroidFindBy(xpath= "//*[@text='Albstadt-Ebingen']")
	private MobileElement select_albstadtEbingen_text;
	
	
	
	
	/*
	 * ========================================================================
	 * 							Methods
	 * ========================================================================
	 */
	
	public void clickDeparture() throws InterruptedException{
		homePage_departure_dropDown_list.click();
		Thread.sleep(2000);
		clickBackButton();
	}
	
	public void selectDeparture() throws Exception 
	{
		isElementPresent(select_albstadtEbingen_text);
			if(isElementPresent(select_albstadtEbingen_text)==false){
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"Albstadt-Ebingen\"));").click();
				Thread.sleep(2000);
				homePage_departure_dropDown_list.getText();
				String ActualText=getText(homePage_departure_dropDown_list);
				String ExpectedText="Albstadt-Ebingen";
				 if (ExpectedText.equals(ActualText))
		            {
		                Assert.assertEquals(ExpectedText, ActualText);
		                System.out.println("Text verified Successfully");
		            }
		            else
		            {
		            	System.out.println("Text Verification Failed");
		            }
			}
		}	
}
