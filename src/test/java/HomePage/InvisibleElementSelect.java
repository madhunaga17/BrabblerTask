package HomePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import UI.screens.HomePage.HomePage;
import actionEngines.DriverBase;

public class InvisibleElementSelect extends DriverBase{
	
	@BeforeClass
	public void launchTheApp() throws Exception
	{
		LaunchApp("Android", "device");
	}
	
	
	@Test
    public void selectDropDownList() throws Exception{
		HomePage hp=new HomePage(driver);
		hp.clickDeparture();
		hp.selectDeparture();
    }
	
	@AfterClass
	public void closeTheApp() {
		closeApp();
	}
}
