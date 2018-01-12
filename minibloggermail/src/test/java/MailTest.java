import com.component.email.EmailService;
import com.icegreen.greenmail.util.GreenMail;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Address;
import javax.mail.internet.MimeMessage;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2017-12-21 16:55
 * @desc
 * @since 1.8
 */
public class MailTest {

    private GreenMail greenMail;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Before
    public void init() {

        this.greenMail = new GreenMail();

        // 设置邮箱账号、密码
        this.greenMail.setUser("xxxx@xx.com", "123456");

        // 启动邮箱
        this.greenMail.start();
    }

    @Test
    public void execute() throws Exception {

        // 加载spring的配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring.xml");

        EmailService emailServiceImpl = (EmailService) applicationContext.getBean("emailServiceImpl");

        emailServiceImpl.sendMail("www.hufeng.site", "xxx", "xxx", true);
    }

    @After
    public void stop() throws Exception {

        MimeMessage[] mimeMessage = greenMail.getReceivedMessages();

        logger.info(mimeMessage[0].getContent().toString());
        logger.info("xxxxx");
        logger.info("yyyyy");

        Address address = mimeMessage[0].getFrom()[0];

        logger.info(address.toString());

        this.greenMail.stop();
    }
}
