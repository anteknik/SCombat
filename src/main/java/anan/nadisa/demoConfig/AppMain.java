package anan.nadisa.demoConfig;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.boot.SpringApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.expression.MethodExecutor;

public class AppMain {
	
	
	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(DemoConfigApplication.class, args);
		Learn ln= (Learn) ctx.getBean("learn");
		ln.result();
		
	}

}
class Learn{
	
	public void result() {
		
		List<String> list = Arrays.asList("node ", "java ", "python ", "ruby ");
		/*
		 * list.forEach(new Consumer<String>() { // anonymous class
		 * 
		 * @Override public void accept(String str) { System.out.println(str); } });
		 */
		
		list.forEach(System.out::println);
	}
	
}

abstract class Advice implements MethodInterceptor{
	
}


class Security extends Advice{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		cek();
		Object obj = invocation.proceed();
		
		return obj;
	}
	
	private static void cek() {
		System.out.println("cek permision");
	}
	
}


class LogAudit extends Advice {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object obj = invocation.proceed();
		cek();
		return obj;
	}
	
	private static void cek() {
		Date date = new Date();
		System.out.println("log audit : "+date);
	}
	
}

class Transaksi extends Advice{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stubout
		System.out.println("transaksi");
		Object obj = invocation.proceed();
		return obj;
	}
	
}
