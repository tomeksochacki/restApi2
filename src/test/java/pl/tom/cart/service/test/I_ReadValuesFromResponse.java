package pl.tom.cart.service.test;

import com.sun.xml.bind.v2.TODO;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

public class I_ReadValuesFromResponse {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void readCalculateValueJsonPath() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String subtotalFirst = response.getBody().jsonPath().getString("subtotal");
        System.out.println(subtotalFirst);
        String subtotal = response.getBody().jsonPath().getString("subtotal");
        System.out.println(subtotal);

        Double subtotalTax = response.getBody().jsonPath().getDouble("subtotal_tax");
        System.out.println(subtotalTax);
        Double subtotalTaxSecond = response.getBody().jsonPath().getDouble("subtotal_tax");
        System.out.println(subtotalTaxSecond);

        Object cartContentsTaxes = response.getBody().jsonPath().getMap("cart_contents_taxes").get("1");
        System.out.println(cartContentsTaxes);

        Object cartContentsTaxesSecond = response.getBody().jsonPath().getMap("cart_contents_taxes").get("1");

        Map<String, Double> cartContentsTaxesMap = response.getBody().jsonPath().getMap("cart_contents_taxes");
        System.out.println(cartContentsTaxesMap.get("1"));
        Map<String, Double> cartContentsTaxesMapSecond = response.getBody().jsonPath().getMap("cart_contents_taxes");
        System.out.println(cartContentsTaxesMapSecond.get("1"));

    }

    @Test
    public void readCalculateValueJsonPath2() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/calculate";
        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);
        //response.getBody().prettyPrint();

        String subtotal = response.getBody().jsonPath().getString("subtotal");
        System.out.println(subtotal);

        Double subtotalTax = response.getBody().jsonPath().getDouble("subtotal_tax");
        System.out.println(subtotalTax);

        Object cartContentsTaxes = response.getBody().jsonPath().getMap("cart_contents_taxes").get("1");
        System.out.println(cartContentsTaxes);

        Map<String, Double> cartContentsTaxesMap = response.getBody().jsonPath().getMap("cart_contents_taxes");
        System.out.println(cartContentsTaxesMap.get("1"));
    }

    @Test
    public void readValueAddItemJsonObject() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 142);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response.getBody().print();
        JSONObject jsonObject = new JSONObject(jsonString);
        String key = jsonObject.getString("key");
        System.out.println(key);

        Integer prodId = jsonObject.getInt("product_id");
        System.out.println(prodId);

        String prodName = jsonObject.getString("product_name");
        System.out.println(prodId);

        Double total = jsonObject.getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);

    }

    @Test
    public void readValueAddItemJsonObject2() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("quantity", 1);
        bodyRequest.put("product_id", "142");
        bodyRequest.put("return_cart", false);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        //response.getBody().prettyPrint();

        String jsonString = response.getBody().print();
        JSONObject obj = new JSONObject(jsonString);
        String key = obj.getString("key");
        System.out.println(key);

        Integer productId = obj.getInt("product_id");
        System.out.println(productId);

        String productName = obj.getString("product_name");
        System.out.println(productName);

        Double total = obj.getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);
    }

    @Test
    public void readValuesAddItemJsonObjectByKey() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 138);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response.getBody().print();
        JSONObject jsonObject = new JSONObject(jsonString);

        Integer productId = jsonObject.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getInt("product_id");
        String productPrice = jsonObject.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getString("product_price");

        Double total = jsonObject.getJSONObject("013d407166ec4fa56eb1e1f8cbe183b9").getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);
    }

    @Test
    public void readValuesAddItemJsonObjectByKey2() {
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("product_id", 140);
        bodyRequest.put("quantity", 1);
        bodyRequest.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        Response response = serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

        String jsonString = response.getBody().print();
        JSONObject jsonObject = new JSONObject(jsonString);

        Integer productId = jsonObject.getJSONObject("1385974ed5904a438616ff7bdb3f7439").getInt("product_id");
        System.out.println(productId);
        String productPrice = jsonObject.getJSONObject("1385974ed5904a438616ff7bdb3f7439").getString("product_price");
        System.out.println(productPrice);
        Double total = jsonObject.getJSONObject("1385974ed5904a438616ff7bdb3f7439").getJSONObject("line_tax_data").getJSONObject("total").getDouble("1");
        System.out.println(total);
    }

    @Test
    public void getCartContentsMap() {
        String endpoint = "/cocart/v1/get-cart";
        Response response = serviceHelper.sendGetRequest(endpoint);

        Map<String, Object> products = response.getBody().jsonPath().get();

        for (Map.Entry<String, Object> product : products.entrySet()) {
            System.out.println(product.getKey());

            Map<String, Object> values = (Map<String, Object>) product.getValue();
            System.out.println(values.get("product_id"));
            System.out.println(values.get("quantity"));
            System.out.println(values.get("product_name"));

            Map<String, Object> lineTaxData = (Map<String, Object>) values.get("line_tax_data");
            Map<String, Double> total = (Map<String, Double>) lineTaxData.get("total");
            System.out.println(total.get("1"));
            System.out.println("#############################");
        }
    }

    @Test
    public void getCartContentsMap2(){
        String endpoint = "/cocart/v1/get-cart";
        Response response = serviceHelper.sendGetRequest(endpoint);
        //response.getBody().prettyPrint();

        Map<String, Object> products = response.getBody().jsonPath().get();

        for (Map.Entry<String, Object> product : products.entrySet()){
            product.getKey();

        Map<String, Object> values = (Map<String, Object>) product.getValue();
            System.out.println(values.get("product_id"));
            System.out.println(values.get("quantity"));
            System.out.println(values.get("product_name"));
            System.out.println("@@@@@@@");


            Map<String, Object> lineTaxData = (Map<String, Object>) values.get("line_tax_data");
            Map<String, Double> total = (Map<String, Double>) lineTaxData.get("total");
            System.out.println(total.get("1"));
        };

    }

    @Test
    public void readValueTotal(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("return", true);

        String endpoint = "/cocart/v1/totals?html=true";
        Response response = serviceHelper.sendGetRequest(bodyRequest.toString(), endpoint);

        String subtotal = response.getBody().jsonPath().getString("subtotal");
        System.out.println(subtotal);

        String cartContentsTax = response.getBody().jsonPath().getString("cart_contents_tax");
        System.out.println(cartContentsTax);

        String jsonString = response.getBody().print();
        JSONObject jsonObject = new JSONObject(jsonString);

        String cartContentsTaxes = jsonObject.getJSONObject("cart_contents_taxes").getString("1");
        System.out.println(cartContentsTaxes);

        String total = jsonObject.getJSONObject("total").getString("1");
        System.out.println(total);


    }
}
