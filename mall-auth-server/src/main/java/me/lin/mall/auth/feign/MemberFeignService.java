package me.lin.mall.auth.feign;

import me.lin.mall.auth.vo.UserRegistVo;
import me.lin.mall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author Fibonacci
 * @Date 2021/3/29 3:31 下午
 * @Version 1.0
 */
@FeignClient("mall-member")
public interface MemberFeignService {
    @PostMapping("/member/member/regist")
    R regist(@RequestBody UserRegistVo registVo);
}
