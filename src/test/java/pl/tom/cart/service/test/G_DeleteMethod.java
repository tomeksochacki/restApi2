package pl.tom.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class G_DeleteMethod {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void removeItemFromCart() {
        String endpoint = "/cocart/v1/item";

        String parameters = "?cart_item_key=a8baa56554f96369ab93e4f3bb068c22&return_cart=true";

        Response response = serviceHelper.sendDeleteRequest(endpoint + parameters);
        response.prettyPrint();
    }

    @Test
    public void removeItemFromCartWithBody() {
        String endpoint = "/cocart/v1/item";

        String bodyRequest = "{\n" +
                        "    \"cart_item_key\": \"a8baa56554f96369ab93e4f3bb068c22\",\n" +
                        "    \"return_cart\": \"true\"\n" +
                        "}";

        Response response = serviceHelper.sendDeleteRequest(bodyRequest, endpoint);
        response.prettyPrint();
    }

    @Test
    public void deleteAllProducts(){
        String endpoint = "/cocart/v1/item";
        JSONObject bodyReqest = new JSONObject();
        bodyReqest.put("cart_item_key","5cf21ce30208cfffaa832c6e44bb567d");
        bodyReqest.put("return_cart", true);

        Response response = serviceHelper.sendDeleteRequest(bodyReqest.toString(), endpoint);
        response.getBody().prettyPeek();
    }
}
