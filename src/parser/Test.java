package parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) {
		String url = "http://m.businfo.go.kr/bp/m/route.do?act=routeNoMain&roNo=93";
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
	        Elements titles = doc.select("a.pl39");
	        if( titles.isEmpty() ) {
	        	titles = doc.select("ul[class=bl mr15] .nx a");
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
