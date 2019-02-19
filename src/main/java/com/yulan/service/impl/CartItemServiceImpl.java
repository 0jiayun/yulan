package com.yulan.service.impl;

import com.yulan.dao.CartItemDao;
import com.yulan.pojo.CartItem;
import com.yulan.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public boolean addCartItem(CartItem cartItem) {
		return cartItemDao.addCartItem(cartItem)>0;
	}

	@Override
	public boolean deleteCartItemByID(int cartItemID) {
		return cartItemDao.deleteCartItemByID(cartItemID)>0;
	}

	@Override
	public CartItem getCartItemByID(int cartItemID) {
		return cartItemDao.getCartItemByID(cartItemID);
	}

	@Override
	public List<CartItem> getCartItems(String cartItemId, String commodityId, BigInteger quantity) {
		return cartItemDao.getCartItems(cartItemId,commodityId,quantity);
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		return cartItemDao.updateCartItem(cartItem)>0;
	}

}