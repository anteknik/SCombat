package anan.nadisa.demoConfig;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoConfigApplication {

	@Bean
	public Security securityAdvice() {
		return new Security();
	}
	
	@Bean
	public LogAudit logAdvice() {
		return new LogAudit();
	}
	@Bean
	public Transaksi tAdvice() {
		return new Transaksi();
		
	}
	

	@Bean
	public ProxyFactoryBean learn() {
		ProxyFactoryBean f = new ProxyFactoryBean();
		Learn l=new Learn();
		f.setTarget(l);
		f.setInterceptorNames("securityAdvice","tAdvice","logAdvice");
		
		return  f;
	}

}
