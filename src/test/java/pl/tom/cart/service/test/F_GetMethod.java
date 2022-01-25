package pl.tom.cart.service.test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class F_GetMethod {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    @Test
    public void getCartContents(){
        String endpoint = "/cocart/v1/get-cart";
        Response response = serviceHelper.sendGetRequest(endpoint);
        response.getBody().prettyPrint();
    }

    @Test
    public void countItems(){
        String endpoint = "/cocart/v1/count-items";
        Response response = serviceHelper.sendGetRequest(endpoint);
        response.getBody().print();
    }

    @Test
    public void restoreItemToCartWithParameters(){
        String key = "a8baa56554f96369ab93e4f3bb068c22";
        Boolean return_cart = true;
        String endpoint = "/cocart/v1/item";
        String parameters = "?cart_item_key=" + key + "&return_cart=" + return_cart;

        Response response = serviceHelper.sendGetRequest(endpoint + parameters);
        response.getBody().prettyPrint();

    }

    @Test
    public void restoreItemToCartWithJsonObject(){
        String endpoint = "/cocart/v1/item";

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("cart_item_key", "a8baa56554f96369ab93e4f3bb068c22");
        bodyRequest.put("return_cart", true);

        Response response = serviceHelper.sendGetRequest(bodyRequest.toString(), endpoint);
        response.getBody().prettyPrint();
    }

    @Test
    public void totalsItemToCartWithParameters(){
        String endpoint = "/cocart/v1/totals";
        Boolean html = true;

        Response response = serviceHelper.sendGetRequest(html, endpoint);
        response.prettyPrint();
    }

    @Test
    public void getAllProduct(){
        String endpoint = "/cocart/v1/get-cart";

        Response response = serviceHelper.sendGetRequest(endpoint);
        response.getBody().prettyPrint();
    }

    @Test
    public void getUser(){
        String endpoint = "/users/random_user";
        JSONObject bodyRequest = new JSONObject();
        Response response = serviceHelper.sendGetRequest(bodyRequest.toString(), endpoint);
        response.getBody().prettyPrint();
    }


    //błedna metoda
    @Test
    public void calculateGetInfo(){
        String endpoint = "/cocart/v1/calculate";

        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
        response.getBody().prettyPrint();

        //response


    }



}
