package com.yulan.dao;

import com.yulan.pojo.CartItem;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

public interface CartItemDao {

	int addCartItem(CartItem cartItem);

	int deleteCartItemByID(int cartItemID);

	CartItem getCartItemByID(int cartItemID);

	List<CartItem> getCartItems(@Param("cartItemId") String cartItemId, @Param("commodityId") String commodityId, @Param("quantity") BigInteger quantity);

	int updateCartItem(CartItem cartItem);

}