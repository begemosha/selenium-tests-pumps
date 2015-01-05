package begemosha.selenium.pumps.logic;

import org.testng.annotations.*;
import static org.junit.Assert.*;

public class LoginTest extends begemosha.selenium.pumps.base.TestBase {

  @BeforeMethod
  public void mayBeLogout() {
    /*if (app.getUserHelper().isNotLoggedIn()) {
      return;
    }
    app.getUserHelper().logout();*/
  }
  
  @Test
  public void testLoginOK() throws Exception {
    /*User user = new User().setLogin("admin").setPassword("admin");
    app.getUserHelper().loginAs(user);
    assertTrue(app.getUserHelper().isLoggedInAs(user));*/
  }

  @Test
  public void testLoginFailed() throws Exception {
    /*User user = new User().setLogin("admin").setPassword("wrong");
    app.getUserHelper().loginAs(user);
    // assertFalse(app.getUserHelper().isLoggedIn());
    assertTrue(app.getUserHelper().isNotLoggedIn());*/
  }

}
