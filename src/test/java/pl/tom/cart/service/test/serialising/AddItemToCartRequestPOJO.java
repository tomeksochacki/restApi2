package pl.tom.cart.service.test.serialising;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.tom.cart.service.test.ServiceHelper;

public class AddItemToCartRequestPOJO {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @JsonProperty
    private Integer quantity;
    @JsonProperty
    private Integer product_id;
    @JsonProperty
    private Boolean return_cart;

    public AddItemToCartRequestPOJO(Integer quantity, Integer productId, Boolean returnCart){
        this.quantity = quantity;
        this.product_id = productId;
        this.return_cart = returnCart;
    }
}
