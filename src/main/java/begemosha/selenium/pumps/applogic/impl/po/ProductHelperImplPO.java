package begemosha.selenium.pumps.applogic.impl.po;

import java.util.List;

import begemosha.selenium.pumps.applogic.ProductHelper;
import begemosha.selenium.pumps.model.Product;

public class ProductHelperImplPO extends DriverBasedHelper implements ProductHelper{

	public ProductHelperImplPO(ApplicationManagerImplPO manager) {
		super(manager.getWebDriver());
	}

	@Override
	public List<Product> getNewProductsList() {
		return pages.newProductsPage.getProductsList();
	}

	@Override
	public void addToCart(Product product) {
		pages.newProductsPage.clickAddToCart(product);		
	}

}
