import static org.junit.Assert.*;

import org.junit.Test;

import main.java.HttpRequest;
import main.java.Parser;

//“ест дл€ проверки парсера
public class ParserTest {

	@Test
	public void test() {
		
		//ћассив адресов, которые должен обработать парсер
		String testURLs[] = {
				"https://google.com",
				"https://yandex.ru",
				"https://habrahabr.ru/",
				"https://geektimes.ru/",
				};
		for(String url:testURLs){
			Parser parser = new Parser(url);
			String body = HttpRequest.get(url).body();
			assertEquals(true, parser.parseHTML(body));
		}
	}

}
