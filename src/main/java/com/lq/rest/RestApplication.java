package com.lq.rest;


import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

/**
 * Created by root on 2017-11-30.
 */
public class RestApplication extends ResourceConfig {
    // 注册JAX-RS应用组件
    public RestApplication(){
        //服务类所在的包路径
        packages("com.lq.jsonservice");

        register(RequestContextFilter.class);	// System
        register(JacksonFeature.class);			// System
        register(JacksonJsonProvider.class);	// System
        register(LoggingFilter.class);			// Log
    }
}