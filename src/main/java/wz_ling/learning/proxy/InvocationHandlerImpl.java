package wz_ling.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object realObject;

    public InvocationHandlerImpl(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before proxy");
        Object invoke = method.invoke(realObject, args);
        System.out.println("after proxy");
        return invoke;
    }
}
