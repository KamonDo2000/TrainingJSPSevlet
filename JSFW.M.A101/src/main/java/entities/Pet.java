package entities;

import java.io.Serializable;

public class Pet implements Serializable {
   
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String type;
    private int age;

    public Pet(String name, String type, int age) {
	this.name = name;
	this.type = type;
	this.age = age;
    }

    public void makeNoise() {
	System.out.println(name + " " + type + " says meow");
    }

    @Override
    public String toString() {
       return "Pet [type=" + type + ", name=" + name + ", age=" + age + "]";
    }

}