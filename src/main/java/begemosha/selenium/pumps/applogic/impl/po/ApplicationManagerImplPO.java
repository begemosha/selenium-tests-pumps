package begemosha.selenium.pumps.applogic.impl.po;

import org.openqa.selenium.WebDriver;

import begemosha.selenium.pumps.applogic.ApplicationManager;
import begemosha.selenium.pumps.applogic.CartHelper;
import begemosha.selenium.pumps.applogic.NavigationHelper;
import begemosha.selenium.pumps.applogic.ProductHelper;
import begemosha.selenium.pumps.applogic.UserHelper;
import begemosha.selenium.pumps.util.Browser;
import begemosha.selenium.pumps.util.PropertyLoader;
import begemosha.selenium.pumps.webdriver.WebDriverFactory;

public class ApplicationManagerImplPO implements ApplicationManager {

  private UserHelper userHelper;
  private NavigationHelper navHelper;
  private ProductHelper prodHelper;

  private WebDriver driver;
  private String baseUrl;
  private CartHelper cartHelper;
  
  public ApplicationManagerImplPO() {
    baseUrl = PropertyLoader.loadProperty("site.url");
    String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

    Browser browser = new Browser();
    browser.setName(PropertyLoader.loadProperty("browser.name"));
    browser.setVersion(PropertyLoader.loadProperty("browser.version"));
    browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

    String username = PropertyLoader.loadProperty("user.username");
    String password = PropertyLoader.loadProperty("user.password");
    
    driver = WebDriverFactory.getInstance(gridHubUrl, browser, username, password);
    // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    userHelper = new UserHelperImplPO(this);
    navHelper = new NavigationHelperImplPO(this);
    prodHelper = new ProductHelperImplPO(this);
    cartHelper = new CartHelperImplPO(this);

    getNavigationHelper().openMainPage();
  }
  
  @Override
  public UserHelper getUserHelper() {
    return userHelper;
  }

  @Override
  public NavigationHelper getNavigationHelper() {
    return navHelper;
  }
  @Override
  public ProductHelper getProductHelper() {
	return prodHelper;
  }
  @Override
  public CartHelper getCartHelper() {
  	return cartHelper;
  }
  protected WebDriver getWebDriver() {
    return driver;
  }

  protected String getBaseUrl() {
    return baseUrl;
  }

  @Override
  public void stop() {
    if (driver != null) {
      driver.quit();
    }
  }

}
