package asd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.function.DoubleConsumer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;	
import org.w3c.dom.DOMConfiguration;

public class asd {
	public static void main(String[] args) throws IOException {

		System.out.println("검색할 단어를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		BufferedReader br;
		String url = "http://m.endic.naver.com/search.nhn?searchOption=all&query="+word+"&=";
		Document doc = (Document) Jsoup.connect(url).get();
		Elements elements = doc.select("a.h_word,ul.desc_lst,p.example_stc,p.example_mean");
//		Elements elements = doc.select("span.autolink");
		int cnt=0;
		for (Element element : elements) {
			if(element.toString().contains("h_word"))
					cnt++;
			if(cnt==2)
				break;
			System.out.println(element.text());
		}System.out.println(url);
	}
}
	