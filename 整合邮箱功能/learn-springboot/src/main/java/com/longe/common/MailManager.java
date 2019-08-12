package com.longe.common;

import com.longe.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailManager {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailConfig mailConfig;

    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 简单的发送text格式的邮件
     * @param subject
     * @param context
     */
    public void sendTextMail(String subject, String context){

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(mailConfig.getFrom());
            mailMessage.setTo(mailConfig.getTo());

            mailMessage.setSubject(subject);
            mailMessage.setText(context);

            mailSender.send(mailMessage);
        } catch (MailException e) {
            e.printStackTrace();
        }

    }

    /**
     * 简单的发送html格式的邮件
     * @param subject
     */
    public void sendHtmlMail(String subject){

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailConfig.getFrom());
            mimeMessageHelper.setTo(mailConfig.getTo());

            mimeMessageHelper.setSubject(subject);

            StringBuilder sb = new StringBuilder();
            sb.append("<!DOCTYPE html>").append("<html lang=\"en\">").append("<body>")
                .append("<table border=\"1\">")
                .append("<tr>")
                .append("<td style=\"color: red\">香蕉</td>")
                .append("<td style=\"color: blue\">苹果</td>")
                .append("<td style=\"color: black\">橘子</td>")
                .append("</tr>")
                .append("</table>")
                .append("</body>").append("</html>");
            mimeMessageHelper.setText(sb.toString(), true);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 发送带附件格式的邮件
     * @param subject
     */
    public void sendAttachmentMail(String subject){

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailConfig.getFrom());
            mimeMessageHelper.setTo(mailConfig.getTo());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText("测试附件");

            //文件路径
            FileSystemResource file = new FileSystemResource(new File("D:\\图片\\test.jpg"));
            mimeMessageHelper.addAttachment("test.jpg", file);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 发送带静态资源的邮件
     * @param subject
     */
    public void sendInlineMail(String subject){

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailConfig.getFrom());
            mimeMessageHelper.setTo(mailConfig.getTo());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText("<html><body>带静态资源的邮件内容，这个一张IDEA配置的照片:<img src='cid:imgId></img></body></html>", true);

            //文件路径
            //FileSystemResource file = new FileSystemResource(new File("D:\\图片\\test.jpg"));
            FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/test.jpg"));
            mimeMessageHelper.addInline("imgId", file);//这里的contentId要和<img src='cid:imgId' />里面的cid一一对应

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于thymeleaf为模板邮件
     * @param subject
     */
    public void sendThymeleafMail(String subject){

        Context context = new Context();
        context.setVariable("email", "111@qq.com");
        String emailContent = templateEngine.process("emailTemplate", context);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailConfig.getFrom());
            mimeMessageHelper.setTo(mailConfig.getTo());
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(emailContent, true);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
