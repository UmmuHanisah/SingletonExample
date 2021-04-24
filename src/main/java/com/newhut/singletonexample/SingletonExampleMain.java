package com.newhut.singletonexample;

/**
 *
 * @author Ummu Hanisah
 * @title Singleton Design Pattern in Java
 * @source https://www.youtube.com/watch?v=VGLjQuEQgkI
 */


/* Note
   ****
    1. What is singleton? Under creational design pattern -> creation of object in Java
    2. Aim? Only one instance of the class should exist throught out the execution
    3. Why do we need it? Database connection

How to implement Singleton design pattern?
******************************************
1. Constructor should be private - so that no multiple object can be created from outside. 
    Only one instance can be created in the Singleton class.
2. Need - public method for returning instance. As instance being created in a 
   private constructor.
3. Intstance should be private and static . 
   Static -> so that it can be called directly from class name.

Initialisation Type:
1. Eager Initialization
2. Lazy Initialization

Thread safe method initialization
Thread safe block initialization

*/

// Eager initialization
class SingletonEager { // defining variable, declaring and initialize it.
    private static SingletonEager instance = new SingletonEager(); 
    /* *Note: 
     1. When the class is loaded, the static block and static variables are initialized 
        because they belong to the class.
     2. It will execute based on the order in the code.
     3. Static variables are initialized only once, at the start of the execution. 
        These variables will be initialized first, before the initialization of any 
        instance variables.
    */
    
    private SingletonEager(){ // private constructor
        int i = 1;
        System.out.println("Execute private constructor: " + i++);
    };

    public static SingletonEager getInstance() { // public method
        return instance;
    }
}

// Lazy initialization - commonly use
class Singleton {
    private static Singleton instance;
    
    private Singleton(){};
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SingletonExampleMain {
    
    // 1: Eager Initialization - as soon as we initialize the instance it 
    //    automatically created at the same time
    
    public static void main(String[] args) {
        SingletonEager instance1 = SingletonEager.getInstance();
        System.out.println("instance1: " + instance1);
        
        SingletonEager instance2 = SingletonEager.getInstance();
        System.out.println("instance2: " + instance2);
    }
}
