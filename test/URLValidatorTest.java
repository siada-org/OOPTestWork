import static org.junit.Assert.*;

import org.junit.Test;

import main.java.URLValidator;

//Тест для проверки класса URLValidator, служащего для проверки ввденного адреса сайта
public class URLValidatorTest {

	@Test
	public void test() {
		
		//Массив "правильных" адресов
		String trueTestURL[] = {
				"google.com",
				"http://google.com",
				"http://www.google.com"
				};
		
		//Массив "неправильных" адресов
		String falseTestURL[] = {
				"googlecom",
				"http:\\google.com",
				"htp://google.com"
		};
		
		URLValidator validator = new URLValidator();
		
		
		for(int i = 0; i<trueTestURL.length; i++){
			boolean test = validator.getCheckURL(trueTestURL[i]);
			
			assertEquals(true, test);
		}
		
		for(int i = 0; i<falseTestURL.length; i++){
			boolean test = validator.getCheckURL(falseTestURL[i]);
			
			assertEquals(false, test);
		}
	}
}
