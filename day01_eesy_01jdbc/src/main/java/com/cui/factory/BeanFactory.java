package com.cui.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建Bean对象的工厂
 * JavaBean：用java语言编写的可重用组件，比如dao，servier，entity等
 *
 * 1. 需要一个配置文件来配置我们的service和dao
 *     配置的内容：唯一标识 全限定类名
 * 2. 通过读取配置文件中配置的内容，反射创建对象
 *     可以是xml也可以是properties
 */
public class BeanFactory {
    public static Properties prop;
    public static Map beans;
    static {
        prop = new Properties();
        try {
            prop.load(BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties"));
            beans = new HashMap();
            String key;
            Object value;
            for (Object o : prop.keySet()) {
                key = String.valueOf(o);
                value = Class.forName(prop.getProperty(key)).newInstance();
                beans.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
