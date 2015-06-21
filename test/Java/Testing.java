package Java;

import com.angecrow.jpa.data.DLUser;
import com.angecrow.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by AnewGrow on 16.06.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class Testing {
    @Autowired
    UserService userService;
    //правильный логин и пароль
    @Test
    public void test1()
    {
        userService.login("admin","admin");
    }
    //неправельный логин и пароль
    @Test
    public void test2()
    {
        userService.login("ad","ad");
    }

}
