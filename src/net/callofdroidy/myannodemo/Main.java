package net.callofdroidy.myannodemo;

import java.lang.reflect.Method;

/**
 * Created by yli on 11/11/16.
 */
public class Main {

    public static void main(String[] args){
        AnimalInterface dog = AnimalFactory.getAnimal(DogImp.class, new AOPMethod() {
            @Override
            public void before(Object proxy, Method method, Object[] args) {
                if(method.getName().equals("getProperty")){
                    System.err.println("success intercept method: " + method.getName() + ", start");
                }
            }

            @Override
            public void after(Object proxy, Method method, Object[] args) {
                if(method.getName().equals("getProperty")){
                    System.err.println("success intercept method: " + method.getName() + ", stop");
                }
            }
        });

        dog.say();
        System.out.println(dog.getName());
        dog.getProperty();
    }


}
