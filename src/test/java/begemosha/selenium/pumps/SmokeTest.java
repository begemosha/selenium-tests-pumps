package begemosha.selenium.pumps;

import java.util.List;

import org.testng.annotations.Test;

import begemosha.selenium.pumps.applogic.ProductHelper;
import begemosha.selenium.pumps.base.TestBase;
import begemosha.selenium.pumps.model.Product;

public class SmokeTest extends TestBase {
	@Test
	public void BuyAnyProductFromMainPageOK() {
		// убедиться что на главной
		// Получаем список новых продуктов, отображаемый на странице
		ProductHelper productHelper = app.getProductHelper();
		List<Product> products = productHelper.getNewProductsList();
		// Выбираем первый же, доступный к заказу
		Product prod2Buy = null;
		for (Product product : products) {
			if (product.isAvailable()) {
				prod2Buy = product;
				break;
			}
		}
		// Добавляем в корзину
		if (prod2Buy != null) productHelper.addToCart(prod2Buy);
		else throw new RuntimeException("Нет ни одного товара, доступного к заказу!");
		// Идем оформлять
		app.getCartHelper().gotoCheckout();
		// Первая страница - контактные данные
		//app.getCheckoutHelper()
		
		
		// Вторая страница
		//System.err.println(products);
	}
}
