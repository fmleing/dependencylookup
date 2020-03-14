package com.feng.dependency.demo;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ObjectProviderDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();

        // 将当前类 ObjectProviderDemo 作为配置类 （Configuration Class)
        configApplicationContext.register(ObjectProviderDemo.class);

        // 启动应用上下文
        configApplicationContext.refresh();

        // 依赖查找集合对象
        lookupByObjectProvider(configApplicationContext);

        // 关闭应用上下文
        configApplicationContext.close();

    }

    @Bean
    public String helloWorld(){
        return "Hello,World";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext configApplicationContext) {
        ObjectProvider<String> objectProvider = configApplicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }
}
