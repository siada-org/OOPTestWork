import static org.junit.Assert.*;

import org.junit.Test;

import main.java.HttpRequest;


//Тест для проверки работы класса HttpRequest, служащего для выполнения http-запросов и получения ответов сервера
public class URLNameTest {

	@Test(expected = main.java.HttpRequest.HttpRequestException.class)
	public void test() {
		
		//Массив ссылок, которые должны выдать результат true
		String trueURL[] = {
			"https://google.com",
			"https://yandex.ru",
			"http://linus.org",
			"https://github.com",
			"https://apple.com"
		};
		
		//Массив ссылок, которые должны вызвать исключение
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
		}
	}
}
