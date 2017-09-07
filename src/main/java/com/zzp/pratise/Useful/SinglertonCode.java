package com.zzp.pratise.Useful;

/**
 * Created by zhuzhengping
 * on 2017/9/7.
 */
public class SinglertonCode {


    //        12. 单实例Singleton 示例

        private static SinglertonCode singleInstance =  new SinglertonCode();

        //Marking default constructor private
        //to avoid direct instantiation.
        private SinglertonCode() {
        }

        //Get instance for class SimpleSingleton
        public static SinglertonCode getInstance() {

            return singleInstance;
        }
//        另一种实现

    public enum SimpleSingleton {
        INSTANCE;
        public void doSomething() {
        }
    }
    //Call the method from Singleton:
//        SimpleSingleton.INSTANCE.doSomething();
}
