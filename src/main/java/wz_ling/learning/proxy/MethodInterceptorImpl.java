package wz_ling.learning.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglid动态代理，方法切入实现类：实现MethodInterceptor类，重写intercept方法
 */
public class MethodInterceptorImpl implements MethodInterceptor {

    /**
     * @param o           代理对象
     * @param method      执行的方法
     * @param objects     方法参数
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before proxy");
        //通过代理类调用父类中的方法，这里有没有其他的调用方式呢？
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("after proxy");
        return invoke;
    }
}
