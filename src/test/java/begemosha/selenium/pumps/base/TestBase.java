package begemosha.selenium.pumps.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import begemosha.selenium.pumps.applogic.ApplicationManager;
import begemosha.selenium.pumps.applogic.impl.po.ApplicationManagerImplPO;

public class TestBase {

  protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManagerImplPO();
	}
	
	@AfterSuite
	public void stop() {
	  app.stop();
	}

}
