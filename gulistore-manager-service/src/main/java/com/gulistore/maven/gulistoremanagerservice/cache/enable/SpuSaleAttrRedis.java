package com.gulistore.maven.gulistoremanagerservice.cache.enable;

import bean.PmsProductSaleAttr;
import com.alibaba.fastjson.JSONObject;
import io.micrometer.core.instrument.util.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 处理 返回SpuSaleAttr对象的缓存
 */
@Aspect
@Component
public class SpuSaleAttrRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Pointcut("@annotation(com.gulistore.maven.gulistoremanagerservice.cache.annon.EnableCustomRedis)" +
            "&within(com.gulistore.maven.gulistoremanagerservice.service.impl.PmsProductSaleAttrServiceImpl)")
    public void pointcut(){}

    @Around("pointcut()")
    public List<PmsProductSaleAttr> getSpuSaleAttrAndAllList(ProceedingJoinPoint proceedingJoinPoint) {

        String key = "pms_product_sale_attr:skuId:" + proceedingJoinPoint.getArgs()[0].toString();
        String lockKey = "pms_product_sale_attr:lock:skuId" + proceedingJoinPoint.getArgs()[0].toString();
        try {
            String value = stringRedisTemplate.opsForValue().get(key);
            if (StringUtils.isBlank(value)) {

                RLock lock = redissonClient.getLock(lockKey);
                lock.lock(10, TimeUnit.SECONDS);

                Object proceed = proceedingJoinPoint.proceed();
                stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(proceed));
                lock.unlock();
                return (List<PmsProductSaleAttr>)proceed;
            }

            return JSONObject.parseArray(value, PmsProductSaleAttr.class);


        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {

        }
        return null;
    }
}
