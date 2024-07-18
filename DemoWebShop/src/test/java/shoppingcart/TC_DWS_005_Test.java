package shoppingcart;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass1;
import com.tricentis.genericutility.ListenerUtility;
import com.tricentis.objectrepository.ShoppingCartPage;
@Listeners(ListenerUtility.class)
public class TC_DWS_005_Test extends BaseClass1 {
	@Test(groups = "system")
	public void deleteProduct()
	{
		hp.getAddToCartButtons().get(1).click(); 
		hp.getShoppingCartLink().click();
		sp = new ShoppingCartPage(driver);
		sp.getRemoveFromCartsRB().get(0).click();
		sp.getUpdateCartButton().click();
		Assert.assertEquals(true, sp.getEmptyCartMessage().isDisplayed(), "Failed to delete the product" );
		//Assert.assertEquals(false, sp.getEmptyCartMessage().isDisplayed(), "Failed to delete the product" ); //failing on purpose 
		test.log(Status.PASS, "Product is deleted successfully from shopping cart");
	}
}
