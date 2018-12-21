package com.baizhi.service;

import com.baizhi.Dto.BannerPageDto;
import com.baizhi.entity.Banner;

public interface BannerService {
    //分页查询
    public BannerPageDto getPageBanners(int page,int rows);
    /*根据id删除一条banner*/
    public void deleteOneBannerById(Integer id);
    /*更新文件的状态*/
    public void updateOneBannerStatus(Banner banner);
    /*添加一条轮播图*/
    public void addOneBanner(Banner banner);
}
