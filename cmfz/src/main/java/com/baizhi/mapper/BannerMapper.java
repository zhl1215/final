package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    /*查询总条数*/
    public Integer queryTotal();
    /*分页查n条数据*/
    public List<Banner> queryRowsByCurPageAndPagesize(@Param("curPage") int curPage, @Param("pageSize") int pageSize);
    /*删除一条数据*/
    public void deleteOneBannerById(Integer id);
    public void updateBannerStatus(@Param("banner") Banner banner);
    /*添加一条数据*/
    public void addOneBanner(@Param(("banner")) Banner banner);
}
