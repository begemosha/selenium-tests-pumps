package begemosha.selenium.pumps.applogic;

import java.util.List;

import begemosha.selenium.pumps.model.Product;

public interface ProductHelper {

	List<Product> getNewProductsList();

	void addToCart(Product product);

}
