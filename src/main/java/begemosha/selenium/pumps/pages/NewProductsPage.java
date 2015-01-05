package begemosha.selenium.pumps.pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import begemosha.selenium.pumps.model.Product;

public class NewProductsPage extends AnyPage {
	
	@FindBy(css = "table.list_product td.block_product")
	private List<WebElement> products;
	
	public NewProductsPage(PageManager pages) {
		super(pages);
	}
	public List<Product> getProductsList() {
		List<Product> result = new LinkedList<>();
		for (WebElement product : products) {
			Product item = new Product();
			// id
			String prodIdClass = product.findElement(By.cssSelector("table[class *= 'productitem_']")).getAttribute("class");
			String prodIdStr = prodIdClass.substring(prodIdClass.indexOf("productitem_") + "productitem_".length());
			item.setId(Integer.valueOf(prodIdStr));
			// name
			item.setName(product.findElement(By.cssSelector("div.name > a")).getText());
			// availability
			WebElement byeBtn = null;
			try {
				byeBtn = product.findElement(By.cssSelector("div.button_buy > a[href *= '/shopping-cart/add']"));
			} catch (NoSuchElementException e) {}
			//WebElement byeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.button_buy > a[href *= '/shopping-cart/add']")));
			item.setAvailable((byeBtn == null) ? false : true);
			result.add(item);
		}
		return result;
	}
	public void clickAddToCart(Product product) {
		WebElement byuBtn = driver.findElement(By.cssSelector("table.list_product td.block_product table[class *= 'productitem_" + String.valueOf(product.getId()) + "'] div.button_buy > a[href *= '/shopping-cart/add']"));
		byuBtn.click();
	}
	@Override
	public Page ensurePageLoaded() {
		// TODO Auto-generated method stub
		return null;
	}

}
