package myspring.aop.xml;
//aspectj 를 사용하는 군
import org.aspectj.lang.ProceedingJoinPoint;

//Around Advice(target의 메서드가 호출되기전과 후에 실행되는 Advice)
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 메서드의 signature 정보(메서드명이 찍힘)
		String signatureString = joinPoint.getSignature().toShortString();		
		System.out.println(signatureString + " 시작");
		//타겟의 메서드가 호출되기 전의 시간 
		long start = System.currentTimeMillis();		
		try {
			//타겟의 메서드 호출(타켓을 진행시켜라 arg를 여기서 조작가능)
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " + 
			   (finish - start) + " ms");
		}
	}
}
