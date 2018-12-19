package com.baizhi.controller;

import com.baizhi.util.ValidateImageCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("/code")
public class ValidateController {
    @ResponseBody
    @RequestMapping("/getValidateCode")
    public void getValidateCode(HttpSession session, HttpServletResponse response){
        String  code = ValidateImageCodeUtils.getSecurityCode();
        //将验证码存在model
        session.setAttribute("code",code);
        //输出验证码
        System.out.println(

                "程序执行到此"
        );
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


}
