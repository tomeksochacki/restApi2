package pl.tom.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import pl.tom.cart.service.test.deserializing.AddItemResponse;
import pl.tom.cart.service.test.deserializing.CalculateResponse;

import java.util.Map;

public class L_Deserializing {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addItemResponseDeserializing() {

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        AddItemResponse responseBody = response.as(AddItemResponse.class);

        System.out.println(responseBody.getKey());
        System.out.println(responseBody.getProduct_id());
        System.out.println(responseBody.getProduct_price());

    /*    Map<String, String> total = (Map<String, String>) responseBody.getLine_tax_data().getTotal();
        Object tot = total.get("1");
        System.out.println(tot.toString());*/

        System.out.println(responseBody.getLine_tax_data().getTotal().getTotal1());
    }

    @Test
    public void calculateGetInfo(){
        String endpoint = "/cocart/v1/calculate";

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
        response.getBody().prettyPrint();

        CalculateResponse bodyresponse = response.as(CalculateResponse.class);
        System.out.println(bodyresponse.getSubtotal());
        System.out.println(bodyresponse.getSubtotal_tax());
        System.out.println(bodyresponse.getCart_contents_taxes().getCartcontentstaxes1());
        System.out.println(bodyresponse.getTotal());
        System.out.println(bodyresponse.getTotal_tax());

    }
}
