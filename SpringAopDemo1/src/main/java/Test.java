import com.tgb.spring.aop.IUser;
import com.tgb.spring.aop.IUserImpl;
import com.tgb.spring.aop.TestSun;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    public  static void main(String args[]){
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUser iUser = (IUser)factory.getBean("user");
//        iUser.findAll();
//        IUser u = new IUserImpl();

//        TestSun test= new TestSun();
        TestSun test = (TestSun)factory.getBean("test");
        test.findSun();
        test.addSun();
    }
}
