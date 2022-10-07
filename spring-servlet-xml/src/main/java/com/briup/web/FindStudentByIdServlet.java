package com.briup.web;

import com.briup.bean.Student;
import com.briup.service.IStudentService;
import com.briup.service.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 什么是Servlet?
 * 1.Servlet本质是一个接口
 * 2.servlet是一个java web程序: 具有处理Http协议。（service对象）
 * 3.
 *
 *
 * 当tomcat创建Servlet对象时，
 * 1.spring框架读取xml文件，创建出service dao层对象
 * 2.将service对象赋值给Servlet对象的service属性
 * @Author lining
 * @Date 2022/10/7
 */
@WebServlet("/findStudentById")
public class FindStudentByIdServlet extends HttpServlet {
    //将service层对象的创建交给ioc容器创建
    private IStudentService service;//=null

    //每次tomcat创建servlet对象，自动调用init()
    public void init() throws ServletException {
        System.out.println("对servlet对象属性进行赋值：ioc容器中获取");
        //对service属性赋值操作 ：container.getBean()

        /*
            1.获取容器对象 WebApplicationContext类型
            我们通过spring-web.jar 实现了用户可以通过servletContext对象获取ioc容器对象
         */
        ApplicationContext container = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        service = container.getBean(IStudentService.class);
    }
    /*    public FindStudentByIdServlet() {
        //1.创建ioc容器。读取spring-service.xml文件 交给spring监听器解决

        service = container.getBean("service");
    }*/

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收请求
        String id = req.getParameter("id");
        //2.调用service对象处理请求参数
        Student s = service.findStudentById(Integer.parseInt(id));
        //3.将结果返回给浏览器
        resp.getWriter().println(service);
    }
}
