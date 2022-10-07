package com.briup.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author lining
 * @Date 2022/10/7
 */
@Configuration//tx.xml
@ComponentScan("com.briup")//service dao对象
@PropertySource("db.properties") //<context:
@EnableTransactionManagement //开启事务管理注解
public class AppConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Bean //任何代码创建对象 框架中使用的到对象
    public JdbcTemplate jdbcTemplate(DataSource ds){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
        return jdbcTemplate;
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
    //创建事务管理器对象
    @Bean
    public PlatformTransactionManager manager(DataSource ds){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(ds);
        return manager;
    }

}
