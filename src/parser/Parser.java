package parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	public Parser() {
		// TODO Auto-generated constructor stub
	}
	
	public void getRouteByNo(String no) {
		String url = "http://m.businfo.go.kr/bp/m/route.do?act=routeNoMain&roNo=" + no;
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
	        Elements titles = doc.select("a.pl39");
	        if( titles.isEmpty() ) {
	        	titles = doc.select("ul.bl.mr15 .nx a");
	        	System.out.println(titles.isEmpty());
	        }
	        
	        String output = "";
	        
	        for(Element e: titles) {
	            output += e.text();
	            output += "\n";
	        }
	        
	        //System.out.println( output.replace("\n\n", "\b") );
	        System.out.println( output );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
