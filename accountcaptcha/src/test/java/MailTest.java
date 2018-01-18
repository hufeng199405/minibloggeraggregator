import com.compoment.captcha.AccountCaptchaService;
import com.compoment.util.RandomGenerator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private AccountCaptchaService accountCaptchaService;

    @Before
    public void prepare() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        accountCaptchaService = (AccountCaptchaService) context.getBean("accountCaptchaService");
    }

    @Test
    public void testGenerateCaptchaKey() throws Exception{

        String key = this.accountCaptchaService.generateCaptchaKey();
        logger.info("生成的key："+key);

        byte[] resultByte = this.accountCaptchaService.generateCaptchaImage(key);

        File file = new File("D:\\拼版\\chekcCode.jpg");

        OutputStream out = null;

        try {

            // 根据字节流写入文件中
            out = new FileOutputStream(file);

            out.write(resultByte);

            out.flush();

            out.close();
        }catch (Exception e){

            if(out != null){

                out.close();
            }
        }
    }
}
