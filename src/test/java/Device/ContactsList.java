package Device;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import UI.screens.Contacts.ContactsPage;
import UI.screens.HomePage.HomePage;
import actionEngines.DriverBase;

public class ContactsList extends DriverBase{
	
	@BeforeTest
	public void launchTheApp() throws Exception
	{
		LaunchApp("Android", "contactPageActivity");
	}
	
	
	@Test(priority=1)
    public void sortByFirstName() throws Exception{
		System.out.println("Sort by first name started");
		ContactsPage cp=new ContactsPage(driver);
		cp.sortByFN();
		System.out.println("Sort by first name Ended");
    }
	
	@Test(priority=2)
    public void sortByLastName() throws Exception{
		System.out.println("Sort by last name started");
		ContactsPage cp=new ContactsPage(driver);
		cp.sortByLN();
		System.out.println("Sort by last name ended");
    }
	
	@AfterClass
	public void closeTheApp() {
		closeApp();
	}
}
