package pl.tom.cart.service.test.deserializing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculateResponse {

    @JsonProperty
    String subtotal;
    @JsonProperty
    Double subtotal_tax;
    @JsonProperty
    String shipping_total;
    @JsonProperty
    Double shipping_tax;
    @JsonProperty
    Object shipping_taxes;
    @JsonProperty
    Double discount_total;
    @JsonProperty
    Double discount_tax;
    @JsonProperty
    String cart_contents_total;
    @JsonProperty
    Double cart_contents_tax;
    @JsonProperty
    CartContentsTaxes cart_contents_taxes;
    @JsonProperty
    String fee_total;
    @JsonProperty
    Double fee_tax;
    @JsonProperty
    Object fee_taxes;
    @JsonProperty
    String total;
    @JsonProperty
    Double total_tax;

    public String getSubtotal() {
        return subtotal;
    }

    public Double getSubtotal_tax() {
        return subtotal_tax;
    }

    public String getShipping_total() {
        return shipping_total;
    }

    public Double getShipping_tax() {
        return shipping_tax;
    }

    public Object getShipping_taxes() {
        return shipping_taxes;
    }

    public Double getDiscount_total() {
        return discount_total;
    }

    public Double getDiscount_tax() {
        return discount_tax;
    }

    public String getCart_contents_total() {
        return cart_contents_total;
    }

    public Double getCart_contents_tax() {
        return cart_contents_tax;
    }

    public CartContentsTaxes getCart_contents_taxes() {
        return cart_contents_taxes;
    }

    public String getFee_total() {
        return fee_total;
    }

    public Double getFee_tax() {
        return fee_tax;
    }

    public Object getFee_taxes() {
        return fee_taxes;
    }

    public String getTotal() {
        return total;
    }

    public Double getTotal_tax() {
        return total_tax;
    }
}
