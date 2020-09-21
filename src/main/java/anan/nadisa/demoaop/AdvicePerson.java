package anan.nadisa.demoaop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AdvicePerson implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("before execution");
		
		Object obj = invocation.proceed();

		System.out.println("after execution");

		return obj;
	}

}
