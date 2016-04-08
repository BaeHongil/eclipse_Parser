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
		
		LinkedHashMap<String, String> linkList = parser.getRouteLinkListByNo("93");
		
		for(Iterator<String> linkitr = linkList.keySet().iterator(); linkitr.hasNext(); ) {
			System.out.println(linkitr.next());
		}
	}

}
