package com.yulan.service;

import com.yulan.pojo.Cart;

import java.util.List;

public interface CartService {

	boolean addCart(Cart cart);

	boolean deleteCartByID(int cartID);

	Cart getCartByID(int cartID);

	List<Cart> getCarts(String cartId, String customerId);

	boolean updateCart(Cart cart);

}