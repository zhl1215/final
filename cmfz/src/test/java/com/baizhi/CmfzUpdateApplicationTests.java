package com.baizhi;

import com.baizhi.Dto.BannerPageDto;
import com.baizhi.entity.Menu;
import com.baizhi.service.BannerService;
import com.baizhi.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzUpdateApplicationTests {
    @Autowired
    MenuService menuService;
    @Autowired
    BannerService bannerService;

    @Test
    public void contextLoads() {
        List<Menu> list =  menuService.getAllMenus();
        System.out.println(list);
    }

    @Test
    public void testBanner() {
        BannerPageDto dto = bannerService.getPageBanners(2,3);
        System.out.println(dto);
        System.out.println(dto.getRows());
    }

}

