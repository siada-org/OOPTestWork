import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import main.java.Exporter;

//���� ��� �������� ����������������� ������ Exporter, ��������� ��� ������ ���������� � ����
public class ExporterTest {

	@Test
	public void test() {
		
		//������� �������� title � description
		String title = "Test title";
		String description = "Test Description";
		
		//������� �������� hashMap � 1000 ������
		Map<String, String> linkMap = new HashMap<String, String>();
		for(int i = 0; i<1000; i++){
			linkMap.put("link_"+i, "http://test_link.com/"+i+"_link.html");
		}
		
		//���������� ��� � ���� � ��������� ������
		Exporter exporter = new Exporter("http://test.url");
		
		assertEquals(true, exporter.writeInfo("title", title));
		assertEquals(true, exporter.writeInfo("description", description));
		assertEquals(true, exporter.writeInfo("links", linkMap));
	}
}
