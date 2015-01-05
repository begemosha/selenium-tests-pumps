package begemosha.selenium.pumps.applogic.impl.po;

import begemosha.selenium.pumps.applogic.CartHelper;

public class CartHelperImplPO extends DriverBasedHelper implements CartHelper {

	public CartHelperImplPO(ApplicationManagerImplPO manager) {
		super(manager.getWebDriver());
	}

	@Override
	public void gotoCheckout() {
		pages.cartPage.ensurePageLoaded().clickCheckout();
	}

}
