package study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import study.annotation.AnnotationAop;

@Component
@Aspect
public class TestAopLanguageAspect {

	/**
	 * 测试使用execution拦截
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* *.getName(..))")
	public Object recordTimeProfiling(ProceedingJoinPoint joinPoint)
			throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		System.out.println("consumes time: "
				+ (System.currentTimeMillis() - start));
		return obj;
	}

	/**
	 * 根据包名拦截
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("within(study.service..*)")
	public Object usePackage(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("use package aspect start");
		Object obj = joinPoint.proceed();
		System.out.println("use package aspect end");
		return obj;
	}
	
	/**
	 * 测试使用注解拦截
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(study.annotation.AnnotationAop)")
	public Object useAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("useAnnotation aspect start");
		Object obj = joinPoint.proceed();
		System.out.println("useAnnotation aspect end");
		return obj;
	}
	
	/**
	 * 测试使用注解拦截, 获取注解内值
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(anno)")
	public Object useAnnotationFetchValue(ProceedingJoinPoint joinPoint, AnnotationAop anno) throws Throwable {
		System.out.println("useAnnotation aspect start: " + anno.value());
		Object obj = joinPoint.proceed();
		System.out.println("useAnnotation aspect end");
		return obj;
	}
}
