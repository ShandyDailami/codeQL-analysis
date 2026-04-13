import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class java_17059_XMLParser_A07 {
    public static void main(String[] args) {
        String urlStr = "https://www.w3schools.com/xml/books.xml";

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new URL(urlStr).openStream(), myHandler);

            List<Book> books = myHandler.getBooks();
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}