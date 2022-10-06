package com.briup.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 配置类；用来配置mybatis框架 简化xml内容
 * @Author lining
 * @Date 2022/10/6
 * dao层的对象称为映射器对象
 */
@Configuration   //mybatis.xml
@ComponentScan("com.briup") // service web层对象
@MapperScan("com.briup.dao")// <bean MapperScannerConfigurer>
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
    //数据库连接池对象
    @Bean
    public DataSource dataSource(){
        //1.创建druid数据库连接池对象
        DruidDataSource ds = new DruidDataSource();
        //2.设置池信息：连接信息+对象数量
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        return ds;
    }

    //创建SqlSessionfactoryBean对象
    @Bean    //<bean SqlSessionFactoryBean>
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds) throws IOException {
        //1.创建Bean对象
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //2.设置基本信息
        sqlSessionFactoryBean.setDataSource(ds);// <properties name=datasouce>
        sqlSessionFactoryBean.setTypeAliasesPackage("com.briup.bean");//<property name="typeAliasesPackage"
        //获取映射文件所在位置：封装在Resouce对象中

        //创建一个资源文件解析器：spring-core.jar
        ResourcePatternResolver
                resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mappers/**/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);//<property name="mapperLocations"

        //设置日志前缀
        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        configuration.setLogPrefix("test---");
        //指定mybatis选择log4j实现日志打印
        configuration.setLogImpl(Log4jImpl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);



        return sqlSessionFactoryBean;
    }




}



