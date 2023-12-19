package tester;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		
//		create instance of ClassPathXmlApplicationContext(String configFile)
//		AutoClosable 
//		to start SC in the standalone environment using xml based metadata
//		instructions placed in run time classpath(i.e <resources>)
		
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class))
		{
			System.out.println("Sc up n running ....");
//			withdraw 1000 from the atm
//			API of o.s.b.f.BeanFactory 
//			<T> T getBean(String beanId/name,class<T> class)
			ATMImpl ref1 = ctx.getBean("my_atm", ATMImpl.class);
			ref1.withdraw(1000);
			
//			another demand fro bean
//			ATMImpl ref2 = ctx.getBean("my_atm", ATMImpl.class);
//			ref2.withdraw(1000);
//			System.out.println(ref1==ref2); //true : since singleton
		}//JVM : ctx.close --> SC shutting down -- tries to call destroy method 
//		on singleton beans -- G.C of all spring beans
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
