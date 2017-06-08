package cn.sfturing.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {
	@Value("#{systemConfigProperties[personal]}")
	private String personal ;
	@Value("#{systemConfigProperties[mailhost]}")
	private String mailhost;
	@Value("#{systemConfigProperties[mailuser]}")
	private String mailuser;
	@Value("#{systemConfigProperties[mailpassword]}")
	private String mailpassword;
	private static Logger log = LoggerFactory.getLogger(MailUtil.class);
	public  Properties getProperties(){
		Properties properties = new Properties();
        // 设置邮件服务器
        properties.put("mail.smtp.host", mailhost);
        // 验证
        properties.put("mail.smtp.auth", "true");
        return properties;
	}
	public  Session getMailSession(){
		// 根据属性新建一个邮件会话
        return Session.getInstance(getProperties(), new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication
                (mailuser, mailpassword);
            }
        });
        
	}
	public boolean sendMail(String toAddress,String title ,String content){
		return sendMail(toAddress, personal, title, content);
		
	}
	@SuppressWarnings("static-access")
	//FIXME:添加异常，显示邮件发送情况。另外，邮件发送，改为异步发送；如果异步，发送成功与否的消息怎么处理？
	public  boolean sendMail(String toAddress, String personal ,String title ,String content){
		final MimeMessage mailMessage;
	    final Transport trans ;
	    Session mailSession = getMailSession();
		
		// 建立消息对象
        mailMessage = new MimeMessage(mailSession);
        try {
			// 发件人
			mailMessage.setFrom(new InternetAddress(mailuser,personal));
			// 收件人
			mailMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toAddress));
			// 主题
			mailMessage.setSubject(title);
			// 内容
//			mailMessage.setText(content);
			mailMessage.setContent(content,"text/html;charset=utf-8");
			// 发信时间
			mailMessage.setSentDate(new Date());
			// 存储信息
			mailMessage.saveChanges();
			trans = mailSession.getTransport("smtp");
			
			//FIXME 需要修改为异步发送消息
			trans.send(mailMessage);
			
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			return false ;
		}
        
		return true ;
	}
	
	public static void main(String[] args) {
		MailUtil mu=new MailUtil();
		mu.sendMail("sfturing@163.com","PRO", "测试", "这是一封测试邮件");
		
	}

}
