package me.lin.mall.product.controller;

import me.lin.mall.common.utils.PageUtils;
import me.lin.mall.common.utils.R;
import me.lin.mall.common.valid.AddGroup;
import me.lin.mall.common.valid.UpdateGroup;
import me.lin.mall.common.valid.UpdateStatusGroup;
import me.lin.mall.product.entity.BrandEntity;
import me.lin.mall.product.service.BrandService;
import me.lin.mall.product.vo.BrandVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 品牌
 *
 * @author Fibonacci
 * @email bugaosuni@gmail.com
 * @date 2020-12-11 14:38:50
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/infos")
    public R infos(@RequestParam("brandIds")List<Long> brandIds){
        List<BrandVo> brandList = brandService.getBrandsByIds(brandIds);
        return R.ok().put("brand", brandList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand){
        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated({UpdateGroup.class}) @RequestBody BrandEntity brand){
		brandService.updateDetail(brand);

        return R.ok();
    }

    /**
     * 修改状态
     */
    @RequestMapping("/update/status")
    public R updateStatus(@Validated({UpdateStatusGroup.class}) @RequestBody BrandEntity brand){
        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
