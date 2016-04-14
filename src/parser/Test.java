package parser;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) {
		Parser parser = new Parser();
		
		LinkedHashMap<String, String> linkList = parser.getRouteLinkListByNo("937");
		
		for(Iterator<String> linkitr = linkList.keySet().iterator(); linkitr.hasNext(); ) {
			String key = linkitr.next();
			System.out.println(key);
			System.out.println(linkList.get(key));
			
			parser.getRouteByUrl(linkList.get(key));
		}
	}

}
