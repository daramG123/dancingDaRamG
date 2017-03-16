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

public class dictionary {
	public static void main(String[] args) throws IOException {

		System.out.println("검색할 단어를 입력해주세요");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		String url = "http://m.endic.naver.com/search.nhn?searchOption=all&query=" + word + "&=";
		Document doc = (Document) Jsoup.connect(url).get();
		Elements elements;
		Elements eswt = doc.select("div.entry_search_word");

		for (Element ele : eswt) {
			System.out.println();
			elements = ele.select("a.h_word,ul.desc_lst>li,p.example_stc,p.example_mean");

			for (Element element : elements) {

				if (element.text().contains("발음듣기")) {
					String stc = element.text().substring(0, element.text().length() - 4);
					System.out.println(stc);
				} else
					System.out.println(element.text());

			}

		}
		System.out.println();
		System.out.println("출처:" + url);
	}
}
