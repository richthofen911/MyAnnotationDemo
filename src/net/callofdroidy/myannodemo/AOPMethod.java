package net.callofdroidy.myannodemo;

import java.lang.reflect.Method;

/**
 * Created by yli on 11/11/16.
 */
public interface AOPMethod {
    // action before instance method executes
    void before(Object proxy, Method method, Object[] args);
    // action after instance method executes
    void after(Object proxy, Method method, Object[] args);
}
