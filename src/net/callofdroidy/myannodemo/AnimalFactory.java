package net.callofdroidy.myannodemo;

import java.lang.reflect.Proxy;

/**
 * Created by yli on 11/11/16.
 */
public class AnimalFactory {

    public static Object getAnimalBase(Object obj, AOPMethod method){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AOPHandler(AnnoInjection.getBean(obj), method));
    }

    /***
     * get object method
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAnimal(Object obj,AOPMethod aopMethod){
        return (T) getAnimalBase(obj,aopMethod);
    }
    /***
     * get object method
     * @param className
    @SuppressWarnings("unchecked")
     * @return
             */
    public static  <T> T getAnimal(String className,AOPMethod method){
        Object obj=null;
        try {
            obj= getAnimalBase(Class.forName(className).newInstance(),method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }

    /***
     * get object method
     * @param clz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static  <T> T  getAnimal(Class<?> clz,AOPMethod method){
        Object obj=null;
        try {
            obj= getAnimalBase(clz.newInstance(),method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }
}
