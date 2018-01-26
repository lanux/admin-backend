package com.lx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Spring的定时任务调度器会尝试获取一个注册过的 task scheduler来做任务调度，它会尝试通过BeanFactory.getBean的方法来获取一个注册过的scheduler bean，获取的步骤如下：
 * 1.尝试从配置中找到一个TaskScheduler Bean
 * 2.寻找ScheduledExecutorService Bean
 * 3.使用默认的scheduler
 * <p>
 * 前两步，如果找不到的话，就会以debug的方式抛出异常，分别是：
 * <p>
 * logger.debug("Could not find default TaskScheduler bean", ex);
 * logger.debug("Could not find default ScheduledExecutorService bean", ex);
 * <p>
 * 所以，日志中打印出来的两个异常，根本不是什么错误信息，也不会影响定时器的使用，只不过是spring的自己打印的一些信息罢了
 */
@Configuration
@EnableScheduling
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SessionConfig {


    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new CookieHttpSessionStrategy();
    }


    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }

    @Bean
    public GenericJackson2JsonRedisSerializer springSessionDefaultRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }


}
