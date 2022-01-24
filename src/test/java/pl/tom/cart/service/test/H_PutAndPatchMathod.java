package pl.tom.cart.service.test;

import org.json.JSONObject;
import org.junit.Test;

public class H_PutAndPatchMathod {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    @Test
    public void updateProductPut(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("Key1", "value1");
        bodyRequest.put("Key2", "value2");
        bodyRequest.put("Key3", "value3");

        String endpoint = "someEndpoint";
        serviceHelper.sendPostRequest(bodyRequest.toString(), endpoint);

    }
}
