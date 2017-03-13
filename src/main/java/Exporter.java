package main.java;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//Класс для записи информации в HTML-файл
public class Exporter {
	
	String FILE_PATH = ".\\report.html";
	
	public Exporter(String adress){
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy hh:mm");
		
		String nowDate = dateFormat.format(date);
		
		try(FileWriter writer = new FileWriter(FILE_PATH, true)){
			String header = "<h1>Отчет от "+nowDate+"</h1><h2>Адрес страницы: \""+adress+"\"</h2>";
			writer.write(header);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//Открытый интерфейс для записи информации в файл
	public boolean writeInfo(String type, String info){
		
		switch(type){
		case "title": return putTitle(info);
		case "description": return putDescription(info);
		default : return false;
		}
	}
	
	//Перегрузка метода-интерфейса writeInfo() для записи ссылок из hasMap
	public boolean writeInfo(String type, Map<String, String> info){
		switch(type){
		case "links": return putLinks(info);
		default : return false;
		}
	}
	
	private boolean putTitle(String info){
		
		try(FileWriter writer = new FileWriter(FILE_PATH, true)){
			
			String title = "<h3>Title страницы: \""+info+"\"</h3>";
			
			writer.append(title);
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	};
	
	//Закрытая реализация для записи информации в файл
	private boolean putDescription(String info){
		try(FileWriter writer = new FileWriter(FILE_PATH, true)){
			
			String title = "<h3>Description страницы: \""+info+"\"</h3>";
			
			writer.append(title);
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
	
	//Закрытя реализация для записи ссылок в файл
	private boolean putLinks(Map<String, String> info){
		try(FileWriter writer = new FileWriter(FILE_PATH, true)){
			Set<Entry<String, String>> set = info.entrySet();
			writer.append("<h3>Ссылки страницы</h3>");
			for(Entry<String, String> vals : set){
				String link = "<p>"+vals.getKey()+" : \""+vals.getValue()+"\"</p>";
				writer.append(link);
			}
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}
}
