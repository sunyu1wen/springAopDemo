import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class CheckUser {
    @Pointcut("execution(* com.tgb.spring.aop.*.find*(..))")
    public void checkAdd(){
        System.out.println("**************<< Add User >> Checking.....***************");
    }

    @Pointcut("execution(* com.tgb.spring.aop.*.find*(..))")
    public void checkUser(){
        System.out.println("********The System is Searching Information For You****checkUser**");
    }

    @Before("checkUser()")
    public void beforeCheck(){
        System.out.println(">>>>>>>> 准备搜查用户..........");
    }
    @Before("checkAdd()")
    public void beforeAdd(){
        System.out.println(">>>>>>>>　增加用户--检查ing..........");
    }

    @After("checkAdd()")
    public void afterAdd(){
        System.out.println(">>>>>>>>　增加用户--检查完毕！未发现异常!..........");
    }

    @After("checkUser()")
    public void afterCheck(){
        System.out.println(">>>>>>>>　搜查用户完毕..........");
    }




    //声明环绕通知
    @Around("checkUser()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---环绕通知");
        Object o = pjp.proceed();
        System.out.println("退出方法---环绕通知");
        return o;
    }
}
