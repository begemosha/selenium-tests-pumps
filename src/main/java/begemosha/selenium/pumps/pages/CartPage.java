package begemosha.selenium.pumps.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AnyPage {
	
	@FindBy(css = "tr#checkout a[href *= 'checkout/step2']")
	private WebElement checkoutBtn;

	public CartPage(PageManager pages) {
		super(pages);
	}

	public void clickCheckout() {
		checkoutBtn.click();
		
	}

	@Override
	public CartPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.cssSelector("form[name='updateCart']")));
		return this;
	}

}
