package com.yulan.dao;

import com.yulan.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartDao {

	int addCart(Cart cart);

	int deleteCartByID(int cartID);

	Cart getCartByID(int cartID);

	List<Cart> getCarts(@Param("cartId") String cartId, @Param("customerId") String customerId);

	int updateCart(Cart cart);

}