package dependency;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//id=httpTransport(derived/generated bean id)
//Singleton and lazy
@Lazy  //lazy-init = true
public class HttpTransport implements Transport {
	public HttpTransport() {
		System.out.println("in cnstr of " +getClass().getName());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass().getName() + " layer");

	}

}
