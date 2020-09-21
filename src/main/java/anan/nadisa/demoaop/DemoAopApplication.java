package anan.nadisa.demoaop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAopApplication {

	@Bean
	public AdvicePerson personAdvice() {
		return new AdvicePerson();
	}

	@Bean
	public ProxyFactoryBean factory() {
		ProxyFactoryBean factory = new ProxyFactoryBean();
		Person p = new Person();
		factory.setTarget(p);
		factory.setInterceptorNames("personAdvice");

		return factory;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoAopApplication.class, args);

		Person p = (Person) ctx.getBean("factory");

		p.test();

	}

}
