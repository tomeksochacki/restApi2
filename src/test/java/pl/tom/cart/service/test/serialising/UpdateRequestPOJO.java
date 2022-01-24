package pl.tom.cart.service.test.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRequestPOJO {

    @JsonProperty
    Integer quantity;
    @JsonProperty
    String product_id;
    @JsonProperty
    Boolean return_cart;

    public UpdateRequestPOJO(Integer quantity, String productId, Boolean returnCart){
        this.quantity = quantity;
        this.product_id = productId;
        this.return_cart = returnCart;
    }
}
