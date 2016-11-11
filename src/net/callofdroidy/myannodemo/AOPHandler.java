package net.callofdroidy.myannodemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yli on 11/11/16.
 */
public class AOPHandler implements InvocationHandler {
    private AOPMethod method;
    private Object object;
    public AOPHandler(Object obj, AOPMethod method){
        this.object = obj;
        this.method = method;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object ret = null;

        this.method.before(proxy, method, args);
        ret = method.invoke(object, args);
        this.method.after(proxy, method, args);;
        return ret;
    }
}
