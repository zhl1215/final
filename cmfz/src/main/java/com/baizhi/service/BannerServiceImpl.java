package com.baizhi.service;

import com.baizhi.Dto.BannerPageDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements  BannerService {
@Autowired
    BannerMapper bannerMapper;
    @Override
    public BannerPageDto getPageBanners(int page, int row) {
        BannerPageDto dto = new BannerPageDto();
        //获得总条数为total赋值
        Integer total = bannerMapper.queryTotal();
        dto.setTotal(total);
        List<Banner> rows = bannerMapper.queryRowsByCurPageAndPagesize(page,row);
        dto.setRows(rows);

        return dto;
    }

    @Override
    public void deleteOneBannerById(Integer id) {
        bannerMapper.deleteOneBannerById(id);

    }

    @Override
    public void updateOneBannerStatus(Banner banner) {
        bannerMapper.updateBannerStatus(banner);

    }

    @Override
    public void addOneBanner(Banner banner) {
        bannerMapper.addOneBanner(banner);
    }
}
