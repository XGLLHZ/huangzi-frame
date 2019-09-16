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
     * 关于微服务：
     *      微服务架构是一项在云中部署应用和服务的新技术。大部分围绕微服务的争论都集中在容器或
     *      其他技术是否能很好的实施微服务，而红帽说 API 应该是重点。
     *      微服务可以在“自己的程序”中运行，并通过“轻量级设备与 HTTP 型 API 进行沟通”。关键在
     *      于该服务可以在自己的程序中运行。通过这一点我们就可以将服务公开与微服务架构（在现有
     *      系统中分布一个 API）区分开来。在服务公开中，许多服务都可以被内部独立进程所限制。如
     *      果其中任何一个服务需要增加某种功能，那么就必须缩小进程范围。在微服务架构中，只需要
     *      在特定的某种服务中增加所需功能，而不影响整体进程。
     *      微服务的核心是 API，在一个大型系统中，我们可以将其拆分为一个个的子模块，每一个模块
     *      就可以是一个服务，各服务之间通过 API 进行通信。
     */

    /**
     * SpringBoot项目启动类备注
     *
     * SpringBoot启动类：文件只要加上@SpringBootApplication注解，就是启动类
     * SpringBootApplication注解： 注解可以用一下三个注解代替
     * SpringBootConfigration注解： 表示SpringBoot的配置注解
     * EnableAutoConfigration注解： 表示自动配置
     * ComponentScan： 表示SpringBoot扫描Bean的规则，比如扫描那些包
     */

    /**
     * SpringBoot项目小知识
     *
     * 1、常量设置：
     *     对于一些涉及到多环境的常量，比如关于datasource的参数，我们可以将其定义在 -prod 和 -dev 的yml文件中
     *     然后创建一个类，一所有定义的常量名为属性，并将其设置成一个Bean，最后在@SpringBootConfigration注解
     *     的类中使用@Value注解将其拿出。使用时只需要引入创建的类即可
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
     *
     * 3、注解@Autowired：没有实现类的接口不能用此注解
     *
     * 4、版本变化：mybatis plus 2.0版本：EntityWrapper
     *             mybatis plus 3.0版本：QueryWrapper
     *
     * 5、关于session、cookie、sessionStorage、localStorage：
     *      为什么选择localStorage来存放用户信息（比如token）：
     *          session：session是存放在服务器上的，这就要求用户在不同时间访问的必须是同一台服务器，但这会在极
     *              大程度上限制负载均衡的能力，所以不推荐
     *          cookie：cookie是存放在浏览器的，也就是客户端，但cookie存在path概念，容易被破解，而且其大小限制
     *              极小，只适合存放小数据，所以不推荐
     *          sessionStorage：sessionStorage是存放在客户端的，但是只在当前窗口关闭前有效，达不到业务需求，所
     *              以不推荐
     *          localStorage：存放在客户端，满足了分布式的负载均衡；持久有效，满足了业务需求；可存放大数据，最多
     *              为5M，适合存放登录凭证（token等）；安全性高，不会被破解。
     *
     * 6、string与int相互转换：
     *      string => int：
     *          1、Integer.valueOf(s).intValue()
     *          2、Integer.parseInt(s)
     *          注：效率（系统运行时间）：1 < 2
     *      int => string：
     *          1、String.valueOf(i)
     *          2、Integer.toString(i)
     *          3、i + ""
     *          注：效率（系统运行时间）：1 < 2 < 3
     *
     * 7、SpringBoot 整合 spring security 时：
     *          若使用了 .loginPage() 方法，则需要添加 SpringBoot 跨域配置
     *
     */

}
