package parser;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
	private String domain = "http://m.businfo.go.kr/bp/m/";

	public Parser() {
		// TODO Auto-generated constructor stub
	}
	
	public LinkedHashMap getRouteLinkListByNo(String no) {
		String url = "http://m.businfo.go.kr/bp/m/realTime.do?act=posInfoMain&roNo=" + no;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
        	Elements titles = doc.select("ul.bl.mr15 .nx a");
	        LinkedHashMap<String, String> linkList = new LinkedHashMap<String, String>();
	        if( !titles.isEmpty() ) {
	        	for(Element e: titles) {
		        //    System.out.println( e.text() );
		        	linkList.put(e.text(), domain + e.attr("href"));
		        }
	        }	        	
	        else 
	        	linkList.put(no, url);	        	
	        

        	return linkList;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	public LinkedHashMap getRouteByUrl(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
	        Elements titles = doc.select(".pl39");
	        LinkedHashMap<String, String> linkList = new LinkedHashMap<String, String>();
	        if( !titles.isEmpty() ) {
	        	for(Element e : titles) {
	        		System.out.println(e.text());
	        	}
	        }	        	

        	return linkList;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
