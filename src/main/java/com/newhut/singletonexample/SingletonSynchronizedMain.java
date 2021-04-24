package com.newhut.singletonexample;

/**
 *
 * @author Ummu Hanisah
 */
public class SingletonSynchronizedMain {

    public static void main(String[] args) {
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println("instance1: " + instance1);
        
        SingletonSynchronized instance2 = SingletonSynchronized.getInstance();
        System.out.println("instance2: " + instance2);
    }

}

class SingletonSynchronized {

    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
        System.out.println("Execute private constructor");
    };
    
    public static SingletonSynchronized getInstance() {
        System.out.println("Execute static method");
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;

    }
}
