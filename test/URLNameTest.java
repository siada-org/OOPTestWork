import static org.junit.Assert.*;

import org.junit.Test;

import main.java.HttpRequest;

public class URLNameTest {

	@Test(expected = main.java.HttpRequest.HttpRequestException.class)
	public void test() {
		String trueURL[] = {
			"https://google.com",
			"https://yandex.ru",
			"http://linus.org",
			"https://github.com",
			"https://apple.com"
		};
		
		String falseURL[] = {
			"htp://google.com",
			"https://ww.google.com",
			"https://linux.org",
		};
		
		for(String url: trueURL){
			int responseCode = HttpRequest.get(url).code();
			assertEquals(true, responseCode==200);
		}
		
		for(String url: falseURL){
			int responseCode = HttpRequest.get(url).code();
			assertFalse(responseCode==200);
		}
	}

}
