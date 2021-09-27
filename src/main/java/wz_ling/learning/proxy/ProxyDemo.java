package wz_ling.learning.proxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyDemo {


    public static void main(String[] args) {
//        jdkProxy();
        cglibProxy();
    }


    private static void cglibProxy() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".\\proxy");
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(RealObject.class);
        enhancer.setCallback(new MethodInterceptorImpl());

        RealObject proxy = (RealObject) enhancer.create();
        proxy.sayGoodBye();
        proxy.playGame("真~三国无双");
    }

    private static void jdkProxy() {
        //设置保存动态生成的class文件，在com.sun.proxy包下
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //代理的真实对象
        RealObject realSubject = new RealObject();
        //代理逻辑织入的地方
        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();

        Object proxy = Proxy.newProxyInstance(loader, interfaces, handler);
        //以下演示了代理成不同的类型
        SayDemo sayProxy = (SayDemo) proxy;
        sayProxy.sayGoodBye();

        PlayDemo playDemo = (PlayDemo) proxy;
        playDemo.playGame("真~三国无双");
    }
}
