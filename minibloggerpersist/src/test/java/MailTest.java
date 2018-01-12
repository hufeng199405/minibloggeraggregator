import com.component.account.model.Account;
import com.component.account.service.AccountPersistService;
import com.component.account.system.util.SystemUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    private AccountPersistService accountPersistService;

    @Test
    public void execute() throws Exception {

        // 加载spring的配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring.xml");

        accountPersistService = (AccountPersistService) applicationContext.getBean("accountPersistServiceImpl");

        //this.insert();

        // 查询信息
        //this.select();

        // 修改信息
        //this.update();

        // 删除信息
        this.delete();
    }

    public void delete() throws Exception{

        this.accountPersistService.deleteAccount("3f36b4cd-9c05-44d3-80d9-9e47d00124d3");
    }

    public void update() throws Exception {

        Account account = new Account();

        account.setId("3f36b4cd-9c05-44d3-80d9-9e47d00124d3");
        account.setName("wangwu");
        account.setPassword("qqq");
        account.setEmail("15574874109@163.com");
        account.setActivated(true);

        this.accountPersistService.updateAccount(account);
    }

    public void insert() throws Exception {

        Account account = new Account();

        account.setId(SystemUtil.generateUuid());
        account.setName("zhangsan");
        account.setPassword("zzzzzz");
        account.setEmail("15574874109@163.com");
        account.setActivated(false);

        accountPersistService.createAccount(account);
    }

    public void select() throws Exception {

        Account account = accountPersistService.selectAccount("5d64ed2c-fbc9-4194-ae9a-2e23c2b647b7");

        System.out.println(account.getId() + "--" + account.getName() + "--" + account.getPassword());
    }
}
