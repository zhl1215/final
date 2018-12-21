package com.baizhi.Dto;

import com.baizhi.entity.Banner;

import java.util.List;

public class BannerPageDto {
    //两个属性，查询到的总条数 total：
    //每一页的条数：rows
    private Integer total;
    private List<Banner> rows;
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public List<Banner> getRows() {
        return rows;
    }
    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }

}
