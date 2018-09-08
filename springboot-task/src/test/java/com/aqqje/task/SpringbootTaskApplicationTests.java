package com.aqqje.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 发送简单的邮件
     */
    @Test
    public void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("aqqjeqnyh@163.com");
        simpleMailMessage.setFrom("1042136232@qq.com");
        // 邮件标题
        simpleMailMessage.setSubject("spring-boot-mail");
        // 邮件内容
        simpleMailMessage.setText("====aqqje learning spring-boot-mail=====");
        mailSender.send(simpleMailMessage);


    }
    /**
     * 发送复杂的邮件
     */
    @Test
    public void test02() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        /**
         * multipart: true
         *  可发送携带附件的邮件
         */
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo("aqqjeqnyh@163.com");
        helper.setFrom("1042136232@qq.com");
        // 邮件标题
        helper.setSubject("<b style='color:red'>spring-boot-mail<b/>");
        // 邮件内容
        helper.setText("====aqqje learning spring-boot-mail=====");
        // 添加图片
        helper.addAttachment("1.jpg", new File("C:\\wallpaper\\360\\317441.jpg"));
        helper.addAttachment("1.jpg", new File("C:\\wallpaper\\360\\319354.jpg"));
        mailSender.send(mimeMessage);
    }

}
