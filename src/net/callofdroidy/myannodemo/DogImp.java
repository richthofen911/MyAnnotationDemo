package net.callofdroidy.myannodemo;

/**
 * Created by yli on 11/11/16.
 */
public class DogImp implements AnimalInterface {

    @Seven(value = "Lumia")
    private String name;
    private String property;

    public DogImp(){
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void say(){
        System.out.println("doggy: wang wang wang");
    }

    @Override
    @Seven(property = "warrior")
    public void setProperty(String property){
        this.property = property;
    }

    @Override
    public void getProperty(){
        System.out.println(this.name + " " + this.property);
    }
}
