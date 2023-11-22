package cn.arcy.testing.controllers;

import cn.arcy.testing.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class DemoController {

    /*@Autowired*/
    private CacheService cacheService;

    @Autowired
    public void setCacheService(CacheService cacheService)
    {
        this.cacheService = cacheService;
    }

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/demo/increaseCount")
    public int increaseCount()
    {
        //CacheService c = applicationContext.getBean(CacheService.class);
        return cacheService.increaseCount();
    }
}
