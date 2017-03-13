import static org.junit.Assert.*;

import org.junit.Test;
import main.java.HttpRequest;

//“ест дл€ проверки соединени€ с удаленными серверми
public class ConnectionTest {

	@Test
	public void test() {
		
		//ћассив ссылок дл€ проверки соедений
		String trueTestUrl[]={
			"https://google.com",
			"https://yandex.com",
			"https://microsoft.com",
			"http://linux.org",
			"https://apple.com"
		};
		
		//ѕроверка €вл€етс€ ли код ответа сервера равным "200"
		for(String url:trueTestUrl){
			int responseCode = HttpRequest.get(url).code();
			assertEquals(true, responseCode==200);
		}
	}

}
