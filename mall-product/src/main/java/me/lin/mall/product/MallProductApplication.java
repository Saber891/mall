package me.lin.mall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * * @author Fibonacci
 * <p>
 * 1.整合Mybatis-Plus
 * 1）.导入依赖
 * <dependency>
 * <groupId>com.baomidou</groupId>
 * <artifactId>mybatis-plus-boot-starter</artifactId>
 * <version>3.3.1</version>
 * </dependency>
 * 2）.配置
 * 1.配置数据源
 * 1）.导入数据库的驱动
 * 2）.在application.yml配置数据源相关信息
 * 2.配置Mybatis-Plus
 * 1）.使用@MapperScan
 * 2）.告诉Mybatis-Plus,sql映射文件位置
 * 2.使用逻辑删除
 * 1).配置全局的逻辑删除规则（省略）
 * 2).配置逻辑删除的组件Bean（省略）
 * 3).给Bean加上逻辑删除注解@TableLogic
 * 3.JSR303
 * 1).给Bean添加校验注解:javax.validation.constraints
 * 2).开启校验功能@Valid效果，校验错误以后会有默认的响应
 * 3).给校验的Bean后紧跟一个BindingResult，就可以获取到校验的结果
 * 4).分组校验
 * 1).@NotBlank(message="品牌名必须校验",groups={AddGroup.class,UpdateGroup.class}
 * 给校验注解标注什么情况需要进行校验
 * 2).@Validated({AddGroup.class})
 * 3).默认没有指定分组的校验注解@NotBlank，在分组校验的情况下不生效
 * 5).自定义校验
 * 1).编写一个自定义的校验注解
 * 2).编写一个自定义的校验器ListValueConstraintValidator
 * 3).关联自定义的校验器和校验注解
 * 4.统一的异常处理
 *
 * @ControllerAdvice 1).编写异常处理类，使用@ControllerAdvice注解
 * 2).使用@ExceptionHandler标注方法可以处理的异常
 * <p>
 * 5.模板引擎
 * 1）.thymeleaf-starter: 关闭缓存
 * 2）.静态资源放在static文件夹下旧课程按照路径直接访问
 * 3）.页面放在templates下，直接访问
 * SpringBoot访问项目的时候会默认找index
 * 6.整合redis
 * 1) .引入data-redis-starter:
 * 2) .简单配置redis的host信息
 * 3）.使用SpringBoot自动配置好的StringRedisTemplate来操作redis
 * redis -> map  key,value
 * <p>
 * 7.整合redisson作为分布式锁等功能的框架
 * 1) .引入依赖
 * 2) .配置redisson MyRedissonConfig给容器中配置一个RedissonClient实例即可
 * 3) .使用
 * 参照文档做
 * <p>
 * 8.整合springcache简化缓存开发
 * 1). 引入依赖
 * spring-boot-starter-cache.spring-boot-data-redis
 * 2). 写配置
 * （1) .自动配置了哪些
 * cacheautoconfiguration会导入rediscacheconfiguration
 * 自动配置好缓存管理器rediscachemanager
 * (2) .配置使用redis作为缓存
 * 3). 测试使用缓存
 */
//@MapperScan("me.lin.mall.product.dao.*")
@EnableRedisHttpSession
@EnableFeignClients(basePackages = "me.lin.mall.product.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }

}
