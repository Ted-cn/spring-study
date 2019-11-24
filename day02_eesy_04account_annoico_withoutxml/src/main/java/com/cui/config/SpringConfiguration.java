package com.cui.config;

import org.springframework.context.annotation.*;

/**
 * 该类是一个配置类，它的作用和bean.xml一样
 *
 * @Configuration：指定当前类是一个配置类
 *     Tips：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。
 * @ComponentScan：指定通过注解指定spring在创建窗口时要扫描的包
 *     value：它和basePackages的作用是一样的，都是用于指定要扫描的包。
 *
 * @Bean：用于把当前方法的返回值作为bean对象存入spring的IOC容器中。
 *     name：用于指定bean的id。默认是当前方法的名称
 *     当我们使用注解配置时，如果方法有参数，spring框架会去容器中查找有没有可用的
 *     bean对象。查找的方式和Autowired注解是一样的。
 * @Import：用于导入其他配置类
 *     value：用于指定其他配置类的字节码。当我们使用Import的注解之后，有Import注解的类就是父配置类，
 *         导入的都是子配置类。
 * @PropertySource：用于指定properties文件的位置
 *     value：指定文件的名称和路径，classpath表示类路径下。
 */
@Configuration
@ComponentScan("com.cui")
@PropertySource(value = "classpath:jdbcConfig.properties")
@Import(JdbcConfiguraiton.class)
public class SpringConfiguration {
}



















