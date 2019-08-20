package org.huangzi.frame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.huangzi.frame.mapper")
public class FrameApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameApplication.class, args);
    }

    /**
     * SpringBoot项目启动类备注
     *
     * SpringBoot启动类：文件只要加上@SpringBootApplication注解，就是启动类
     * @SpringBootApplication注解可以用一下三个注解代替
     * @SpringBootConfigration：表示SpringBoot的配置注解
     * @EnableAutoConfigration：表示自动配置
     * @ComponentScan：表示SpringBoot扫描Bean的规则，比如扫描那些包
     */

    /**
     * SpringBoot项目小知识
     *
     * 1、常量设置：
     *    对于一些涉及到多环境的常量，比如关于datasource的参数，我们可以将其定义在 -prod 和 -dev 的yml文件中
     *    然后创建一个类，一所有定义的常量名为属性，并将其设置成一个Bean，最后在@SpringBootConfigration注解
     *    的类中使用@Value注解将其拿出。使用时只需要引入创建的类即可
     *
     */

}
