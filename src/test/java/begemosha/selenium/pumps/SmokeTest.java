package begemosha.selenium.pumps;

import java.util.List;

import org.testng.annotations.Test;

import begemosha.selenium.pumps.applogic.ProductHelper;
import begemosha.selenium.pumps.base.TestBase;
import begemosha.selenium.pumps.model.Product;

public class SmokeTest extends TestBase {
	@Test
	public void BuyAnyProductFromMainPageOK() {
		// ��������� ��� �� �������
		// �������� ������ ����� ���������, ������������ �� ��������
		ProductHelper productHelper = app.getProductHelper();
		List<Product> products = productHelper.getNewProductsList();
		// �������� ������ ��, ��������� � ������
		Product prod2Buy = null;
		for (Product product : products) {
			if (product.isAvailable()) {
				prod2Buy = product;
				break;
			}
		}
		// ��������� � �������
		if (prod2Buy != null) productHelper.addToCart(prod2Buy);
		else throw new RuntimeException("��� �� ������ ������, ���������� � ������!");
		// ���� ���������
		app.getCartHelper().gotoCheckout();
		// ������ �������� - ���������� ������
		//app.getCheckoutHelper()
		
		
		// ������ ��������
		//System.err.println(products);
	}
}
