package com.briup.web;

import com.briup.bean.Student;
import com.briup.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lining
 * @Date 2022/10/10
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Autowired //spring框架管理servlet对象可以注入service的依赖
    private IStudentService service;//属性的对象从哪里来？

    @Override
    public void init() throws ServletException {
        //1.通过一个工具类获取一个ioc容器：
        WebApplicationContext container = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        //true web.xml 指定了ContextClass实现类
        System.out.println(container instanceof AnnotationConfigWebApplicationContext);


        //2.通过ioc容器获取一个可以使对象拥有自动装配能力的工厂对象
        AutowireCapableBeanFactory beanFactory = container.getAutowireCapableBeanFactory();
        //3.将servlet对象交给工厂对象实现依赖注入的操作
        //谁调用该方法，谁就是this(实例)
        beanFactory.autowireBean(this);//this=Servlet对象
        // this.service = container.getBean(IStudentService.class)
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String id = req.getParameter("id");
        //2.将请求参数封装在一个对象中,并交给service进行处理
        Student s = new Student(Integer.parseInt(id), username);
        service.addStudent(s);
        //3.返回处理结果：字符串 html
        resp.getWriter().println("hello "+username);
    }
}
