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
     * @SpringBootApplication 注解可以用一下三个注解代替
     * @SpringBootConfigration： 表示SpringBoot的配置注解
     * @EnableAutoConfigration： 表示自动配置
     * @ComponentScan： 表示SpringBoot扫描Bean的规则，比如扫描那些包
     */

    /**
     * SpringBoot项目小知识
     *
     * 1、常量设置：
     *    对于一些涉及到多环境的常量，比如关于datasource的参数，我们可以将其定义在 -prod 和 -dev 的yml文件中
     *    然后创建一个类，一所有定义的常量名为属性，并将其设置成一个Bean，最后在@SpringBootConfigration注解
     *    的类中使用@Value注解将其拿出。使用时只需要引入创建的类即可
     *
     * 2、spring security 中的密码加密:
     *     BCryptPasswordEncoder：该类中提供了两个方法，encode 和 matches，即密码加密和密码匹配。
     *     密码加密：采用的是 SHA-256+随机盐+密钥对密码加密，其中的SHA-256是 hash 算法，不可逆，
     *     但在加密算法中，加密算法是可逆的，可逆就意味着可解密，那就不安全。
     *     密码匹配：是将用户登录时传入的密码用同样的算法加密，然后与数据库中已经加密后的密码进行比较，
     *     虽然每次对相同的密码（123456）加密的结果也就是hash值是不一样的，但是通过密码匹配方法得出的
     *     却是 true。
     *     注：在密码传输的过程中使用 bcrypt.js 加密（也就是从前端传到后台时），因为 BCryptPasswordEncoder
     *     内部采用应该是相同的算法吧！
     */

}
