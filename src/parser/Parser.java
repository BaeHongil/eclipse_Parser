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
	
	// �����뼱 �˻�
	public LinkedHashMap getRouteLinkListByNo(String no) {
		String url = domain + "realTime.do?act=posInfoMain&roNo=" + no;
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
	
	// ������ġ���� �˻�
	public LinkedHashMap getRouteByUrl(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
	        Elements titles = doc.select(".bl");
	        //Elements titles = doc.select(".pl39");
	        LinkedHashMap<String, String> linkList = new LinkedHashMap<String, String>();
	        if( !titles.isEmpty() ) {
	        	for(Element e : titles) {
	        		for(Element e2 : e.children()) {
	        			if( e2.classNames().contains("bloc_b") ) { // nsbus�� �������
	        				System.out.print("��ġ : ");
		        			System.out.println(e2.text());	        				
	        			}
	        			else
	        				System.out.println(e2.child(1).text());
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
	
	// ���������� �˻�
	public LinkedHashMap getBusStopByStr(String str) {
		String url;
		Document doc;
		try {
			url = domain + "realTime.do?act=arrInfoMain&bsNm=" +  URLEncoder.encode(str, "UTF-8");
			doc = Jsoup.connect(url).get();
        	Elements titles = doc.select(".pl39");
	        LinkedHashMap<String, String> linkList = new LinkedHashMap<String, String>();
	        if( !titles.isEmpty() ) {
	        	for(Element e: titles) {
		        //    System.out.println( e.text() );
		        	linkList.put(e.text(), domain + e.attr("href"));
		        }
	        }	        	
	        else 
	        	linkList.put(str, url);	        	
	        

        	return linkList;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
