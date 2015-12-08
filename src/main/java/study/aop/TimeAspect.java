package study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
	@Around("execution(* *.m1(..))")
	public Object recordTimeProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		System.out.println("consumes time: "
				+ (System.currentTimeMillis() - start));
		return obj;
	}
}
