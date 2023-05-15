package guru.springframework.sfgdi;

import guru.springframework.sfgdi.contollers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.PrototoypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("---------- Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------- Setter");
		SetterInjectionedController setterInjectionedController = (SetterInjectionedController) ctx.getBean("setterInjectionedController");
		System.out.println(setterInjectionedController.getGreeting());

		System.out.println("----- Constructor");
		ContructorInjectedController contructorInjectedController = (ContructorInjectedController) ctx.getBean("contructorInjectedController");
		System.out.println(contructorInjectedController.getGreeting());

		System.out.println("----- Primary");
		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println(myController.sayHello());

		System.out.println("-----I18");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());


		System.out.println("----- Bean scope ------" );
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototoypeBean prototoypeBean1 = ctx.getBean(PrototoypeBean.class);
		System.out.println(prototoypeBean1.getMyScope());
		PrototoypeBean prototoypeBean2 = ctx.getBean(PrototoypeBean.class);
		System.out.println(prototoypeBean2.getMyScope());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());


	}

}
