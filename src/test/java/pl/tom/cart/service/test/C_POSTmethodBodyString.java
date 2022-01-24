package pl.tom.cart.service.test;

import org.junit.Test;

public class C_POSTmethodBodyString {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemWithBodyString() {

        Integer productId = 142;
        Integer quantity = 2;
        Boolean returnCart = true;

        String bodyRequest = "{\n" +
                "    \"quantity\": " + quantity + ",\n" +
                "    \"product_id\": " + productId + ",\n" +
                "    \"return_cart\": " + returnCart + "\n" +
                "}";

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

    @Test
    public void calculateItemWithBodyString() {

        Boolean calculate = true;

        String bodyRequest = "{\n" +
                "    \"return\": " + calculate + ",\n" +
                "}";

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(bodyRequest, endpoint);
    }

    @Test
    public void addProductWithBodyString() {

        Integer productId = 142;
        Integer quantity = 5;
        Boolean returnCart = true;

        String bodyRequest = "{\n" +
                "    \"quantity\": " + quantity + ",\n" +
                "    \"product_id\": " + productId + ",\n" +
                "    \"return_cart\": " + returnCart + "\n" +
                "}";

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(bodyRequest,endpoint);
    }

    @Test
    public void updateNumberOfProduct(){
        String endpoint = "/cocart/v1/item";

        String cartItemKey = "a8baa56554f96369ab93e4f3bb068c22";
        Boolean returnCart = true;
        Integer quantity = 15;

        String requestBody = "{\n" +
                "    \"cart_item_key\": " + cartItemKey + ",\n" +
                "    \"return_cart\": " + returnCart + ",\n" +
                "    \"quantity\": " + quantity + "\n" +
                "}";

        serviceHelper.sendPostRequest(requestBody, endpoint);
    }
}
