package wz_ling.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * jdk动态代理调用类：关键是实现InvocationHandler接口，重写invoke方法
 */
public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object realObject;

    public InvocationHandlerImpl(Object realObject) {
        this.realObject = realObject;
    }

    /**
     * 1、重写InvocationHandler方法
     * 2、代理的前后逻辑都是在重写invoke方法中实现
     *
     * @param proxy  被代理对象
     * @param method 目标方法
     * @param args   方法参数
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before proxy");
        Object invoke = method.invoke(realObject, args);
        System.out.println("after proxy");
        return invoke;
    }
}
