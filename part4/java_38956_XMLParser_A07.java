import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class java_38956_XMLParser_A07 {

    public static void main(String[] args) {
        String url = "https://example.com/sample.xml"; // replace with your URL
        parse(url);
    }

    public static void parse(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            printElements(document.select("name"));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void printElements(Elements elements) {
        for (Element element : elements) {
            System.out.println("Name: " + element.text());
            // You can add more logic to process each element here
        }
    }
}