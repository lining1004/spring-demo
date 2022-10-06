package com.briup.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 配置类：简化xml配置 实现创建bean对象
 * @Author lining
 * @Date 2022/10/6
 * 几个bean对象？？？ dao对象  template对象  datasource对象
 * 对象之间有联系：依赖关系
 */
@Configuration//配置类   jdbc.xml
@ComponentScan("com.briup")   // <bean> StudentDao对象
@PropertySource("db.properties")
public class AppConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //spring调用方法时，提供datasource对象作为参数
    @Bean// <bean> jdbcTemplate对象
    public JdbcTemplate jdbcTemplate(DataSource ds){
        System.out.println("创建jdbcTemplate");
        //1.创建template对象
        JdbcTemplate jt = new JdbcTemplate();
        //2.依赖与Datasouce对象
        jt.setDataSource(ds); //<properties ...>
        return jt;
    }
    @Bean  //<bean> datasouce对象
    public DataSource dataSource(){
        System.out.println("创建datasource");
        //1.创建数据库连接池对象
        DruidDataSource ds = new DruidDataSource();
        //2.读取到配置文件，获取设置连接池信息
        ds.setUrl(url);
        ds.setDriverClassName(driver);
        ds.setPassword(password);
        ds.setUsername(username);
        return ds;
    }
}
