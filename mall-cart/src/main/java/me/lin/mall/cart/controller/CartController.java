package me.lin.mall.cart.controller;

import me.lin.mall.cart.interceptor.CartInterceptor;
import me.lin.mall.cart.service.CartService;
import me.lin.mall.cart.vo.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.ExecutionException;

/**
 * 浏览器有一个cookie；user-key：标识用户身份，一个月后过期；
 * 如果第一次使用购物车，会给一个临时用户的身份
 * 浏览器以后保存，每次访问都会带上这个cookie
 * <p>
 * 登录：session有
 * 没登录: 按照cookie里面带来的user-key来做
 * 第一次：如果没有临时用户，帮忙创建一个临时用户
 *
 * @Author Fibonacci
 * @Date 2021/4/13 1:52 下午
 * @Version 1.0
 */
@Controller
public class CartController {

    final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart.html")
    public String cartListPage() {

        CartInterceptor.threadLocal.get();

        return "cartList";
    }

    /**
     * 添加商品到购物车
     *
     * @return
     */
    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("skuId") Long skuId,
                            @RequestParam("num") Integer num,
                            RedirectAttributes attributes) throws ExecutionException, InterruptedException {

        cartService.addToCart(skuId, num);
        attributes.addAttribute("skuId", skuId);
        return "redirect:http://cart.linmall.com/addToCartSuccess.html";
    }

    /**
     * addFlashAttribute() 将数据放在session里面，可以在页面取出，但是只能取出一次
     *
     * @param skuId
     * @param model
     * @return
     */
    @GetMapping("/addToCartSuccess.html")
    public String addToCartSuccessPage(@RequestParam("skuId") Long skuId, Model model) {
        //重定向到成功页面，再次查询购物车数据即可
        CartItem item = cartService.getCartItem(skuId);
        model.addAttribute("item", item);
        return "success";
    }

}
