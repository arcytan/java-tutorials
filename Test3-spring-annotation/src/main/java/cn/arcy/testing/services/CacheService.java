package cn.arcy.testing.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class CacheService {

    private int count = 0;

    public int increaseCount()
    {
        return ++count;
    }
}
