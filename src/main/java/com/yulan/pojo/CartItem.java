package com.yulan.pojo;

import java.math.BigInteger;

public class CartItem {

	private String cartItemId;
	private String commodityId;
	private BigInteger quantity;

	public String getCartItemId() {
		return this.cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId=cartItemId;
	}

	public String getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId=commodityId;
	}

	public BigInteger getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity=quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CartItem cartItem = (CartItem) o;

		if(cartItemId != null ? !cartItemId.equals(cartItem.cartItemId) : cartItem.cartItemId !=null) return false;
		if(commodityId != null ? !commodityId.equals(cartItem.commodityId) : cartItem.commodityId !=null) return false;
        if(quantity != null ? !quantity.equals(cartItem.quantity) : cartItem.quantity !=null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = cartItemId!=null ? cartItemId.hashCode() : 0;
		result = 31 * result + (commodityId!=null ? commodityId.hashCode() : 0);
		result = 31 * result + (quantity!=null ? quantity.hashCode() : 0);
		return result;
	}
}