package parser;

import java.io.IOException;
import java.net.URLEncoder;
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
	
	// 버스노선 검색
	public LinkedHashMap<String,String> getRouteListByNo(String no) {
		String url = domain + "realTime.do?act=posInfoMain&roNo=" + no;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
        	Elements titles = doc.select("ul.bl.mr15 .nx a");
	        LinkedHashMap<String, String> linkList = new LinkedHashMap<String, String>();
	        if( !titles.isEmpty() ) {
	        	for(Element e: titles) {
		        	linkList.put(e.text(), e.absUrl("href"));
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
	
	// 버스위치정보 검색
	public LinkedHashMap<String,String> getRouteByUrl(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
	        Elements titles = doc.select(".bl");
	        LinkedHashMap<String, String> linkList = new LinkedHashMap<String, String>();
	        if( !titles.isEmpty() ) {
	        	for(Element e : titles) {
	        		for(Element e2 : e.children()) {
	        			if( e2.classNames().contains("bloc_b") ) { // nsbus는 저상버스
	        				System.out.print("위치 : ");
		        			System.out.println(e2.text());
	        			}
	        			else
	        				System.out.println(e2.child(1).text().substring( e2.child(1).text().indexOf(". ")+2 ));
	        		}
	        		//System.out.println(e.text());
	        	}
	        }	        	

        	return linkList;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	// 버스정류장 검색
	public LinkedHashMap<String,String> getBusStopListByWord(String word) {
		String url;
		Document doc;
		try {
			url = domain + "realTime.do?act=arrInfoMain&bsNm=" + word;
			doc = Jsoup.connect(url).get();
        	Elements titles = doc.select(".pl39");
	        LinkedHashMap<String, String> linkList = new LinkedHashMap<String, String>();
	        if( !titles.isEmpty() ) {
	        	for(Element e: titles) {
		        	linkList.put(e.text(), e.absUrl("href"));
		        }
	        }	        	
	        else 
	        	linkList.put(word, url);
	        

        	return linkList;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
