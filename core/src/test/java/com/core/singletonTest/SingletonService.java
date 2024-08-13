package com.core.singletonTest;

public class SingletonService {
    private static final SingletonService instance  = new SingletonService(); // 생성자가 아닌 변수?

    public static SingletonService getInstance(){
        return instance;
    }
    private SingletonService(){

    }


}
