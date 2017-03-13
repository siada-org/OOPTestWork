package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


// ласс служит дл€ проверки на соответсви€ введенной строки модели URL

public class URLValidator {
	public boolean getCheckURL(String URLString){
		return checkURL(URLString);
	}
	
	private boolean checkURL(String URLString){
		
		//ѕроверка полученной строки на соответсвие регул€рному выражению
		Pattern checkPattern = Pattern.compile("(http://)?(https://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?");
		Matcher matcher = checkPattern.matcher(URLString);
		return matcher.matches();
	}
}
