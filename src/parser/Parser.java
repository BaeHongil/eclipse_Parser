package parser;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	public Parser() {
		// TODO Auto-generated constructor stub
	}
	
	public LinkedHashMap getRouteLinkListByNo(String no) {
		String url = "http://m.businfo.go.kr/bp/m/route.do?act=routeNoMain&roNo=" + no;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
	        Elements titles = doc.select("a.pl39");
	        LinkedHashMap<String, String> linkList = new LinkedHashMap<String, String>();
	        if( !titles.isEmpty() ) {
	        	linkList.put(no, url);
	        }	        	
	        else {
	        	titles = doc.select("ul.bl.mr15 .nx a");
	        	for(Element e: titles) {
		            System.out.println( e.text() );
		        	linkList.put(e.text(), e.attr("href"));
		        }
	        }

        	return linkList;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
