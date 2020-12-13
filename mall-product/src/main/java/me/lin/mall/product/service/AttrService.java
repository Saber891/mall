package me.lin.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;

import me.lin.common.utils.PageUtils;
import me.lin.mall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author Fibonacci
 * @email bugaosuni@gmail.com
 * @date 2020-12-11 14:38:50
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
