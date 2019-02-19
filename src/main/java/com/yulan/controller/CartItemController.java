package com.yulan.controller;

import com.yulan.pojo.CartItem;
import com.yulan.service.CartItemService;
import com.yulan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cartItem")
public class CartItemController{

	@Autowired
	private CartItemService cartItemService;

	@ResponseBody
	@RequestMapping("addCartItem")
	public Map<String,Object> addCartItem(CartItem cartItem) {
		if(cartItemService.addCartItem(cartItem))
			return Response.getResponseMap(0,"添加成功",null);
		else
			return Response.getResponseMap(1,"添加失败",null);
	}

	@ResponseBody@RequestMapping("deletecartItem")
	public Map<String,Object> deleteCartItem(@RequestParam("cartItemID")int cartItemID) {
		if(cartItemService.deleteCartItemByID(cartItemID)) {
			return Response.getResponseMap(0,"修改成功",null);
		}
		else {
			return Response.getResponseMap(1,"修改失败",null);
		}
	}

	@ResponseBody@RequestMapping("getCartItemByID")
	public CartItem getCartItemByID(int cartItemID) {
		return cartItemService.getCartItemByID(cartItemID);
	}

	@ResponseBody@RequestMapping("getCartItems")
	public List<CartItem> getCartItems() {
		return cartItemService.getCartItems(null,null,null);
	}

	@ResponseBody@RequestMapping("getCartItemsDeal")
	public Map<String,Object> getCartItemsDeal(@RequestParam(value = "cartItemId",required=false)String cartItemId,@RequestParam(value = "commodityId",required=false)String commodityId,@RequestParam(value = "quantity",required=false) BigInteger quantity) {
		return Response.getResponseMap(0,"",cartItemService.getCartItems(cartItemId,commodityId,quantity));
	}

	@ResponseBody@RequestMapping("updateCartItem")
	public Map<String,Object> updateCartItem(CartItem cartItem) {
		if(cartItemService.updateCartItem(cartItem)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"",null);
		}
	}

}