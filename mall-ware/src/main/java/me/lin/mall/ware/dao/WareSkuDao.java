package me.lin.mall.ware.dao;

import me.lin.mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author Fibonacci
 * @email bugaosuni@gmail.com
 * @date 2020-12-11 22:59:58
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}