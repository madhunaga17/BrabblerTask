package UI.screens.Contacts;

import UI.screens.common.PageBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ContactsPage extends PageBase{


	public ContactsPage(AppiumDriver driver) {
		super((AndroidDriver) driver);
	}

	/*
	 * ========================================================================
	 * 							Locators
	 * ========================================================================
	 */
	
	@AndroidFindBy(xpath= "//*[@text='Settings']")
	private MobileElement contacts_settings_menu;
	
	@AndroidFindBy(xpath= "//*[@text='Contacts']")
	private MobileElement contacts_contacts_menu;
	
	@AndroidFindBy(xpath= "//*[@text='Sort by']")
	private MobileElement contacts_sortBy_menu;
	
	@AndroidFindBy(xpath= "//*[@text='First name']")
	private MobileElement contacts_firstName_optionButton;
	
	@AndroidFindBy(xpath= "//*[@text='Last name']")
	private MobileElement contacts_lastName_optionButton;
	
	@AndroidFindBy(xpath= "//*[@text='First Last']")
	private MobileElement contacts_firstLast_name;
	
	@AndroidFindBy(xpath= "//*[@text='F']")
	private MobileElement contacts_f_frame;
	
	@AndroidFindBy(xpath= "//*[@text='L']")
	private MobileElement contacts_l_frame;
	
	
	/*
	 * ========================================================================
	 * 							Methods
	 * ========================================================================
	 */
	

	@SuppressWarnings("deprecation")
	public void sortByFN() throws Exception{
		clickMenu();
        contacts_settings_menu.click();
        contacts_contacts_menu.click();
        contacts_sortBy_menu.click();
        contacts_firstName_optionButton.click();
        clickBackButton();
        clickBackButton();
        Thread.sleep(2000);
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"G\"));");
        Thread.sleep(2000);
        System.out.println(isElementPresent(contacts_f_frame)+ ": Element is displayed");
        System.out.println(isElementPresent(contacts_firstLast_name)+ ": Element is displayed");

	}
	
	@SuppressWarnings("deprecation")
	public void sortByLN() throws Exception{
		clickMenu();
        contacts_settings_menu.click();
        contacts_contacts_menu.click();
        contacts_sortBy_menu.click();
        contacts_lastName_optionButton.click();
        clickBackButton();
        clickBackButton();
        Thread.sleep(2000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+ "new UiSelector().text(\"M\"));");
        Thread.sleep(2000);
        System.out.println(isElementPresent(contacts_l_frame)+" : Element is displayed");
        System.out.println(isElementPresent(contacts_firstLast_name)+" : Element is displayed");

	}	
}
