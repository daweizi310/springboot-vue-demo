package com.maxton.common.response;

import java.util.List;

/**
 * @Description 分页统一类
 * @Author maxton.zhang
 * @Date 2019/10/31 9:16
 * @Version 1.0
 */

public class PageResult<T> {

    //数据列表
    private List<T> rows;
    //数据总数
    private long total;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
