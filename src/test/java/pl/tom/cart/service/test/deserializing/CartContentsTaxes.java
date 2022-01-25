package pl.tom.cart.service.test.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartContentsTaxes {

    @JsonProperty("1")
    private Double cartcontentstaxes1;

    public Double getCartcontentstaxes1() {
        return cartcontentstaxes1;
    }
}
