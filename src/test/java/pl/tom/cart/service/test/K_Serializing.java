package pl.tom.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import pl.tom.cart.service.test.serialising.AddItemToCartRequestPOJO;
import pl.tom.cart.service.test.serialising.UpdateRequestPOJO;

public class K_Serializing {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItem() {
        Integer productId = 142;
        Integer quantity = 1;
        Boolean returnCart = true;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(quantity, productId, returnCart);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);

        response.getBody().prettyPrint();
    }

    @Test
    public void addTenItem() {
        Integer productId = 1692;
        Integer quantity = 10;
        Boolean returnCart = false;

        AddItemToCartRequestPOJO bodyRequest = new AddItemToCartRequestPOJO(quantity, productId, returnCart);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest, endpoint);

        String jsonString = response.getBody().print();
        JSONObject obj = new JSONObject(jsonString);

        String key = obj.getString("key");
        System.out.println(key);


        String cartItemKey = key;
        Integer quantityUpdate = 2;
        Boolean returnCartUpdate = false;
        String endpoint2 = "/cocart/v1/item";

        UpdateRequestPOJO updateRequestBody = new UpdateRequestPOJO(quantityUpdate, cartItemKey, returnCartUpdate);
        serviceHelper.sendPostRequest(updateRequestBody, endpoint2);
    }
}
