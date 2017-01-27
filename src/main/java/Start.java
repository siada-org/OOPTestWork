package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	
	static URLValidator validator;

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
			validator = new URLValidator();
			if(validator.checkURL(siteURL)){
				System.out.println("SUCCESS");
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
