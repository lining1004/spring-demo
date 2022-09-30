import com.briup.bean.Student;
import com.briup.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;

/**
 *
 * alt+insert 新增XXXX
 * @Author lining
 * @Date 2022/9/30
 */
@SpringJUnitConfig(classes = AppConfig.class)
public class Test2Junit5 {
    @Resource
    private Student student;
    @Test
    public void method(){
        System.out.println(student);
    }
}
