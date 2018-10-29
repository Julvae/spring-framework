package org.springframework.web.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;

import java.util.HashMap;
import java.util.Map;

public class SLogFactory {
    private static Map<Class, Log> mapper = new HashMap<Class, Log>();

    public static Log getLog(Class tClass){
        Log logger = mapper.get(tClass);
        if(logger == null){
            synchronized(tClass.getClass()){
                logger = mapper.get(tClass);
                if(null == logger){
                    logger = LogFactory.getLog(HandlerMethod.class);
                    mapper.put(tClass, logger);
                }
            }
        }
        return logger;
    }

    public static void main(String[] args){
        Log log = getLog(HandlerMethod.class);
        log = getLog(HandlerMethod.class);
        log = getLog(HandlerMethod.class);
    }
}
