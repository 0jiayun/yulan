package com.yulan.controller;

import com.yulan.pojo.Cart;
import com.yulan.service.CartService;
import com.yulan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cart")
public class CartController{

	@Autowired
	private CartService cartService;

	@ResponseBody
	@RequestMapping("addCart")
	public Map<String,Object> addCart(Cart cart) {
		if(cartService.addCart(cart))
			return Response.getResponseMap(0,"添加成功",null);
		else
			return Response.getResponseMap(1,"添加失败",null);
	}

	@ResponseBody@RequestMapping("deletecart")
	public Map<String,Object> deleteCart(@RequestParam("cartID")int cartID) {
		if(cartService.deleteCartByID(cartID)) {
			return Response.getResponseMap(0,"修改成功",null);
		}
		else {
			return Response.getResponseMap(1,"修改失败",null);
		}
	}

	@ResponseBody@RequestMapping("getCartByID")
	public Cart getCartByID(int cartID) {
		return cartService.getCartByID(cartID);
	}

	@ResponseBody@RequestMapping("getCarts")
	public List<Cart> getCarts() {
		return cartService.getCarts(null,null);
	}

	@ResponseBody@RequestMapping("getCartsDeal")
	public Map<String,Object> getCartsDeal(@RequestParam(value = "cartId",required=false)String cartId,@RequestParam(value = "customerId",required=false)String customerId) {
		return Response.getResponseMap(0,"",cartService.getCarts(cartId,customerId));
	}

	@ResponseBody@RequestMapping("updateCart")
	public Map<String,Object> updateCart(Cart cart) {
		if(cartService.updateCart(cart)) {
			return Response.getResponseMap(0,"",null);
		} else {
			return Response.getResponseMap(1,"",null);
		}
	}

}