package begemosha.selenium.pumps.applogic;

public interface ApplicationManager {

	UserHelper getUserHelper();
	NavigationHelper getNavigationHelper();
	ProductHelper getProductHelper();
	CartHelper getCartHelper();
	
	void stop();


}
