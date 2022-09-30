import com.briup.bean.Student;
import com.briup.config.AppConfig;
import com.briup.web.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @Author lining
 * @Date 2022/9/30
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestJunit5 {
    @Resource
    private Student student;

    //获取到web层对象，调用方法

    @Autowired
    private UserController controller;

    @Test
    public void method(){
        System.out.println(student);
        controller.findUserById(1);
    }
}
