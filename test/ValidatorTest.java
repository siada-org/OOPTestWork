import static org.junit.Assert.*;

import org.junit.Test;

import main.java.URLValidator;

public class ValidatorTest {

	@Test
	public void test() {
		
		String trueTestURL[] = {
				"google.com",
				"http://google.com",
				"http://www.google.com"
				};
		
		String falseTestURL[] = {
				"googlecom",
				"http:\\google.com",
				"htp://google.com"
		};
		
		URLValidator validator = new URLValidator();
		
		for(int i = 0; i<trueTestURL.length; i++){
			boolean test = validator.checkURL(trueTestURL[i]);
			
			assertEquals(true, test);
		}
		
		for(int i = 0; i<falseTestURL.length; i++){
			boolean test = validator.checkURL(falseTestURL[i]);
			
			assertEquals(false, test);
		}
	}

}
