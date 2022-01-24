package pl.tom.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class D_POSTmethodBodyJsonObject {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyJsonObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 10);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void  calculateItemWithBodyJsonObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void addNewProductWithBodyJsonObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("quantity", 15);
        bodyRequest.put("product_id",1692);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void updateItemWithBodyJsonObject(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        bodyRequest.put("return_cart", true);
        bodyRequest.put("quantity", 2);

        String endpoint = "/cocart/v1/item";

        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void addProductToCartWithJson(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("quantity", 10);
        bodyRequest.put("product_id", 1696);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
        response.getBody().prettyPrint();
    }
}
