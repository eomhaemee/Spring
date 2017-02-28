package myspring.aop.xml;
//aspectj �� ����ϴ� ��
import org.aspectj.lang.ProceedingJoinPoint;

//Around Advice(target�� �޼��尡 ȣ��Ǳ����� �Ŀ� ����Ǵ� Advice)
public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�� �޼����� signature ����(�޼������ ����)
		String signatureString = joinPoint.getSignature().toShortString();		
		System.out.println(signatureString + " ����");
		//Ÿ���� �޼��尡 ȣ��Ǳ� ���� �ð� 
		long start = System.currentTimeMillis();		
		try {
			//Ÿ���� �޼��� ȣ��(Ÿ���� ������Ѷ� arg�� ���⼭ ���۰���)
			Object result = joinPoint.proceed();
			return result;
		} finally {
			//Ÿ���� �޼��尡 ȣ��� ���� �ð�
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����");
			System.out.println(signatureString + " ���� �ð� : " + 
			   (finish - start) + " ms");
		}
	}
}
