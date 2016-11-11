package net.callofdroidy.myannodemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yli on 11/11/16.
 */
public class AnnoInjection {

    public static Object getBean(Object obj){
        try{
            Field fields[] = obj.getClass().getDeclaredFields();

            for(Field field : fields){
                Seven s = field.getAnnotation(Seven.class);
                if(s != null){
                    System.err.println("inject property: " + field.getName() + ": " + s.value());
                    // reflect invoke public setter, if the access level is private, then setter can used directly
                    obj.getClass()
                            .getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), new Class[] {String.class})
                            .invoke(obj, s.value());
                }
            }
            Method methods[] = obj.getClass().getDeclaredMethods();
            for(Method method : methods){
                Seven s = method.getAnnotation(Seven.class);
                if (s != null) {
                    System.err.println("inject " + method.getName() + "method " + ": " + s.property());
                    method.invoke(obj, s.property());
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
