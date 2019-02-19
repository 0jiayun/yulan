package com.yulan.service.impl;

import com.yulan.dao.CartDao;
import com.yulan.pojo.Cart;
import com.yulan.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public boolean addCart(Cart cart) {
		return cartDao.addCart(cart)>0;
	}

	@Override
	public boolean deleteCartByID(int cartID) {
		return cartDao.deleteCartByID(cartID)>0;
	}

	@Override
	public Cart getCartByID(int cartID) {
		return cartDao.getCartByID(cartID);
	}

	@Override
	public List<Cart> getCarts(String cartId,String customerId) {
		return cartDao.getCarts(cartId,customerId);
	}

	@Override
	public boolean updateCart(Cart cart) {
		return cartDao.updateCart(cart)>0;
	}

}