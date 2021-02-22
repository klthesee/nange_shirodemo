import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zk.ShiroDemoApplication;
import com.zk.domain.Account;
import com.zk.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@EnableAutoConfiguration
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShiroDemoApplication.class)
public class AccountMapperTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void test01(){
        List<Account> accountList = accountMapper.selectList(new QueryWrapper<Account>());
        accountList.forEach(System.out::println);
        System.out.println();
    }
}
