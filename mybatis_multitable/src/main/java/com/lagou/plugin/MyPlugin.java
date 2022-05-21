package com.lagou.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({//注意看这个⼤花括号，也就这说这⾥可以定义多个@Signature对多个地⽅拦截，都⽤这个拦截器
        @Signature(type= StatementHandler.class,//这是指拦截哪个接⼝
                  method = "prepare",//这个接⼝内的哪个⽅法名，不要拼错了
                  args = {Connection.class,Integer.class})// 这是拦截的⽅法的⼊参，按
        // 顺序写到这，不要多也不要少，如果⽅法重载，可是要通过⽅法名和⼊参来确定唯⼀的
})
public class MyPlugin implements Interceptor {
    //这⾥是每次执⾏操作的时候，都会进⾏这个拦截器的⽅法内
    /*
        拦截方法：只要被拦截的目标对象的目标方法被执行时，每次都会执行intercept方法
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //增强逻辑
        System.out.println("对方法进行了增强....");
        return invocation.proceed(); //执行原方法
    }

    /*
       主要是为了把这个拦截器⽣成⼀个代理放到拦截器链中
        target为要拦截的对象
        Return 代理对象
     */
    @Override
    public Object plugin(Object target) {
        // wrap(Object target, Interceptor interceptor)
        // target是被拦截的目标对象。interceptor就是自定义的插件类。
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    /*
        获取配置文件的参数
        插件初始化的时候调⽤，也只调⽤⼀次，插件配置的属性从这⾥设置进来
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("获取到的配置文件的参数是："+properties);
    }
}
