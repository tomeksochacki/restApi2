package pl.tom.cart.service.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pl.tom.cart.service.test.serialising.AddItemToCartRequestPOJO;
import pl.tom.cart.service.test.serialising.UpdateRequestPOJO;
import utils.GetPropertyValues;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class ServiceHelper {

    GetPropertyValues getPropertyValues = new GetPropertyValues();
    private final String LOGIN = getPropertyValues.getPropValue("login");
    private final String PASSWORD = getPropertyValues.getPropValue("password");
    private final String BASE_URI = getPropertyValues.getPropValue("shopServerUrl");
    private final SampleRest SAMPLE_REST = new SampleRest();

    public void addItem(Integer productId, Integer quantity, Boolean returnCart, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .queryParam("quantity", quantity)
                .queryParam("product_id", productId)
                .queryParam("return_cart", returnCart)
                .baseUri(BASE_URI)
                .post(endpoint);
    }

    public Response sendPostRequest(Map<String, Object> queryParamsBody, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .queryParams(queryParamsBody)
                .baseUri(BASE_URI)
                .post(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendPostRequest(String body, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .contentType(ContentType.JSON)
                //.contentType("application/json")
                //.header("Content-Type", "application/json")
                .body(body)
                .baseUri(BASE_URI)
                .post(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendGetRequest(String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .baseUri(BASE_URI)
                .get(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendDeleteRequest(String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .baseUri(BASE_URI)
                .delete(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendGetRequest(String body, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .contentType(ContentType.JSON)
                //.contentType("application/json")
                //.header("Content-Type", "application/json")
                .body(body)
                .baseUri(BASE_URI)
                .get(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendGetRequest(Boolean html, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .queryParam("html", html)
                .baseUri(BASE_URI)
                .get(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendDeleteRequest(String body, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .contentType(ContentType.JSON)
                //.contentType("application/json")
                //.header("Content-Type", "application/json")
                .body(body)
                .baseUri(BASE_URI)
                .delete(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendPutRequest(String body, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .contentType(ContentType.JSON)
                //.contentType("application/json")
                //.header("Content-Type", "application/json")
                .body(body)
                .baseUri(BASE_URI)
                .put(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendPostRequest(AddItemToCartRequestPOJO body, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .contentType(ContentType.JSON)
                //.contentType("application/json")
                //.header("Content-Type", "application/json")
                .body(body)
                .baseUri(BASE_URI)
                .post(endpoint);
        return SAMPLE_REST.response;
    }

    public Response sendPostRequest(UpdateRequestPOJO body, String endpoint) {
        SAMPLE_REST.response = given()
                .auth()
                .preemptive()
                .basic(LOGIN, PASSWORD)
                .contentType(ContentType.JSON)
                //.contentType("application/json")
                //.header("Content-Type", "application/json")
                .body(body)
                .baseUri(BASE_URI)
                .post(endpoint);
        return SAMPLE_REST.response;
    }
}

class SampleRest {
    public Response response;
}
