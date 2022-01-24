package pl.tom.cart.service.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class B_POSTmethodBodyFormData {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void addIthemWithBodyFormData() {
        Integer productId = 142;
        Integer quantity = 2;
        Boolean returnCart = true;

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.addItem(productId, quantity, returnCart, endpoint);
    }

    @Test
    public void addIthemWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("product_id", "142");
        queryParamsBody.put("quantity", 5);
        queryParamsBody.put("return_cart", true);

        String endpoint = "/cocart/v1/add-item";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }

    @Test
    public void calculateWithBodyMap() {
        Map<String, Object> queryParamsBody = new HashMap<>();
        queryParamsBody.put("returne", true);

        String endpoint = "/cocart/v1/calculate";

        serviceHelper.sendPostRequest(queryParamsBody, endpoint);
    }
}
