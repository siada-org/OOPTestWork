package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	
	static URLValidator validator;
	static HttpRequest HttpRequest;

	public static void main(String[] args) {
		run();
	}
	private static void run(){
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter website adress");
		String siteURL;
		try {
			siteURL = consoleReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			siteURL = "empty";
		}
		if(siteURL!="empty"){
			//проверка введеной строки на URL
			validator = new URLValidator();
			if(validator.getCheckURL(siteURL)){
				
				String adress = null;
				
				//проверка на наличие протокола в адресе страницы и добавление его в случае отсутствия
				if(siteURL.contains("http://")||siteURL.contains("https://")){
					adress = siteURL;
				}else{
					adress = "http://"+siteURL;
				}
				//получение исходного кода страницы и передача параметром парсеру
				String response = main.java.HttpRequest.get(adress).body();
				Parser parser = new Parser(adress);
				parser.getHTML(response);
			}else{
				System.out.println("Web adress invalid, try again. Adress example 'google.com'");
				run();
			}
		}else{
			System.out.println("Error, try restart programm");
			run();
		}
	}
}
