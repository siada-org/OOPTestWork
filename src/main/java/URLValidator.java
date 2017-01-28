package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator { //public interface
	public boolean getCheckURL(String URLString){
		return checkURL(URLString);
	}
	
	private boolean checkURL(String URLString){ //private realization
		Pattern checkPattern = Pattern.compile("(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?");
		Matcher matcher = checkPattern.matcher(URLString);
		return matcher.matches();
	}
}
