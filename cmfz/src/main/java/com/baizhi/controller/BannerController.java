package com.baizhi.controller;

import com.baizhi.Dto.BannerPageDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;
    @ResponseBody
    @RequestMapping("/getPageRows")
    /*分页查询*/
    public BannerPageDto getPageBanners(int page, int rows){
     return  bannerService.getPageBanners(page,rows);
        }
        @RequestMapping("/deleteOneBanner")
        @ResponseBody
     public String deleteOneBanner(Integer id){
        bannerService.deleteOneBannerById(id);
        return "ok";
        }
        @ResponseBody
    @RequestMapping("/updateBannerStatus")
    public String updateBannerStatus(Banner banner){

        bannerService.updateOneBannerStatus(banner);
        return "ok";


    }

    /*上传文件并添加*/
    @ResponseBody
    @RequestMapping("/addBanner")
    public String addBanner(@RequestParam("uploadFile")MultipartFile file , HttpSession session, Banner banner) throws IOException {
        //获取上传的文件
        System.out.println("获得文件"+file);
        String name = UUID.randomUUID().toString().replaceAll("-", "");

        //获取文件扩展名
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());

        //设置图片上传路径
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/showImage/shouye/");
        //以绝对路径保存重命名后的图片
        System.out.println("realpath="+realPath);
        file.transferTo(new File(realPath + "/" + name + "." + ext));
        //把图片路径存到数据库
        //http://localhost:8787/" + "Img/" +
        String imgname = name + "." + ext;
        banner.setImg_path(imgname);
        banner.setPub_date(new Date());
        banner.setStatus("down");
        bannerService.addOneBanner(banner);
        System.out.println("添加成功");
        return "success";




    }

    }

