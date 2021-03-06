package me.lin.mall.search.service;

import me.lin.mall.search.vo.SearchParam;
import me.lin.mall.search.vo.SearchResult;

/**
 * @Author Fibonacci
 * @create: 2021-03-02 16:55
 * @Version 1.0
 */
public interface MallSearchService {

    /**
     *  查询
     * @param param 查询条件
     * @return
     */
    SearchResult search(SearchParam param);
}
