package com.osd.ssop.controller;

/**
 * Created by chenbinghao on 17/5/11.下午3:32
 */

import com.sun.tools.javac.jvm.Gen;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.util.Random;

/**
 * 控制验证码的controller
 */
@Controller
@RequestMapping("ssop")
public class CodeController {


    private int width = 90;//验证码宽度
    private int height = 25;//验证码高度
    private int codeCount = 5;//验证码个数
    private int lineCount = 25;//混淆线个数

    char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    /**
     * 具体获取验证码的方法
     * @param time  time为时戳,这样的话可以避免浏览器缓存验证码
     * @throws IOException
     */
    @RequestMapping(value = "/code/{time}",method = RequestMethod.GET)
    public void getCode(@PathVariable("time") String time, HttpServletRequest request,
                        HttpServletResponse response) throws IOException{
        //定义随机数类
        Random r = new Random();
        //定义存储验证码的类
        StringBuilder builderCode = new StringBuilder();
        //定义画布
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //得到画笔
        Graphics g = buffImg.getGraphics();
        //1.设置颜色,画边框
        g.setColor(Color.black);
        g.drawRect(0,0,width,height);
        //2.设置颜色,填充内部
        g.setColor(Color.white);
        g.fillRect(1,1,width-2,height-2);
        //3.设置干扰线
        g.setColor(Color.gray);
        for (int i = 0; i < lineCount; i++) {
            g.drawLine(r.nextInt(width),r.nextInt(width),r.nextInt(width),r.nextInt(width));
        }
        //4.设置验证码
        g.setColor(Color.blue);
        //4.1设置验证码字体
        g.setFont(new Font("Verdana", Font.BOLD|Font.ITALIC, 20));
        for (int i = 0; i < codeCount; i++) {
            char c = codeSequence[r.nextInt(codeSequence.length)];
            builderCode.append(c);
            g.drawString(c+"", 13*(i+1), 20);
        }

        //1.保存到session中
        HttpSession session = request.getSession();
        session.setAttribute("codeValidate", builderCode.toString());

        //2.禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/png");
        //3.输出到屏幕
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(buffImg,"png",sos);

        //4.关闭sos
        sos.close();
    }

}
