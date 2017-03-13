package org.mpb.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Shaon on 3/11/2017.
 */
@Aspect
@Component
public class LoggerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    @Before("execution(* org.mpb.service.PostService.getPosts (java.lang.Integer, java.lang.Integer)) && args(pageNo, size)")
    public void beforeGetPosts(Integer pageNo, Integer size) {
        LOGGER.info("A request was issued for a sample name: " + pageNo + ":" + size);
    }
}
