package com.gulistore.maven.gulistoremanagerservice.cache.annon;

import java.lang.annotation.*;

/**
 * 方法上标注该注解表示该方法将使用Redis缓存, 具体实现在cache.enable包中
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableCustomRedis {
}
