package com.cui.cglib;

import org.springframework.beans.BeanUtils;

class Dog {
    private String name;
    private int age;

    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

public class Demo {

    public static void main(String[] args) {
        Dog d1 = new Dog();
        Dog d2 = new Dog();

        d1.setName("d1");
        d1.setAge(1);
        //d1.setColor("black");

        d2.setName("d2");
        d2.setAge(2);
        d2.setColor("white");

        System.out.println(d1);
        System.out.println(d2);
        BeanUtils.copyProperties(d1, d2);
        System.out.println(d1);
        System.out.println(d2);
        /**
         * 结论：copyProperties会拷贝一个一模一样的副本，即使是空值。
         */
    }
}
