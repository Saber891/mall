package me.lin.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import me.lin.mall.common.utils.PageUtils;
import me.lin.mall.ware.entity.PurchaseDetailEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author Fibonacci
 * @email bugaosuni@gmail.com
 * @date 2020-12-11 22:59:59
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 通过id获取采购单详细信息
     * @param id 采购单id
     * @return 采购单详细信息
     */
    List<PurchaseDetailEntity> listDetailByPurchaseId(Long id);
}

