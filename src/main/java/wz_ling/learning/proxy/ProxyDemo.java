package wz_ling.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {


    public static void main(String[] args) {
        //设置保存动态生成的class文件，在com.sun.proxy包下
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //代理的真实对象
        RealObject realSubject = new RealObject();
        //代理逻辑织入的地方
        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();

        SayDemo sayProxy = (SayDemo) Proxy.newProxyInstance(loader, interfaces, handler);
        sayProxy.sayGoodBye();

        PlayDemo playDemo = (PlayDemo) Proxy.newProxyInstance(loader, interfaces, handler);
        playDemo.playGame("真~三国无双");
    }
}
