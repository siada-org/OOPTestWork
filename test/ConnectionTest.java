import static org.junit.Assert.*;

import org.junit.Test;
import main.java.HttpRequest;

public class ConnectionTest {

	@Test
	public void test() {
		String trueTestUrl[]={
			"https://google.com",
			"https://yandex.com",
			"https://microsoft.com",
			"http://linux.org",
			"https://apple.com"
		};
		for(String url:trueTestUrl){
			int responseCode = HttpRequest.get(url).code();
			assertEquals(true, responseCode==200);
		}
	}

}
