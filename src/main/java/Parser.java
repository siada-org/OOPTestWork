package main.java;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//����� ������ ��� ���������� �������� ������
public class Parser {
	
	Exporter exporter;
	
	public Parser(String adress){
		exporter = new Exporter(adress);
	}
	
	public void getHTML(String body){
		parseHTML(body);
	}
	
	public boolean parseHTML(String body){
		Document html = Jsoup.parse(body);
		
		Map<String, String> linkMap = new HashMap<String, String>();
		
		//��������� description ��������
		Elements metaDescription = html.select("meta[name=\"description\"]");
		Elements links = html.select("a");
		
		//��������� title ��������
		String title = html.title();
		System.out.println("Write title is "+exporter.writeInfo("title", title)+". Title is \""+title+"\"");
		
		//������ � ��������� ������ � ������ title � description
		String description = metaDescription.attr("content");
		System.out.println("Write description is "+exporter.writeInfo("description", description)+". Description is \""+description+"\"");
		
		//�������� ��� ������ � ������ � �������� ������ Exporter ��� ������ � ����
		for(Element link : links){
			linkMap.put(link.text(), link.attr("href"));
		}
		if(exporter.writeInfo("links", linkMap)){
			System.out.println("Links scan done, count "+linkMap.size());
			return true;
		}else{
			return false;
		}
	}
}
