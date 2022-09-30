import com.briup.bean.Student;
import com.briup.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 编写单元测试代码：
 * 1.获取ioc容器的bean对象
 * 使用注解方式创建bean对象,获取bean对象
 * spring-test模块：实现 junit和spring整合
 * //1.读取配置文件 配置类 指定扫描包 本质上创建ioc对象
 * @Author lining
 * @Date 2022/9/30
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestJunit4 { //spring创建对象
    @Autowired
    private Student student;//将ioc容器的bean对象赋值到属性上

    @Test
    public void getBean(){
        System.out.println(student);
    }
}
