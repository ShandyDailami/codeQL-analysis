import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_12795_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/books.xml";

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new InputSource(new File(fileName)), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private List<String> authorNames = new ArrayList<>();
    private List<String> bookTitles = new ArrayList<>();
    private List<Integer> publicationYears = new ArrayList<>();
    private StringBuilder authorName;
    private StringBuilder bookTitle;
 
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {
        if ("author".equals(localName)) {
            authorName = new StringBuilder();
        } else if ("title".equals(localName)) {
            bookTitle = new StringBuilder();
        } else if ("year".equals(localName)) {
            publicationYears = new ArrayList<>();
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        String content = new String(chars, start, length);
        if ("author".equals(authorName)) {
            authorNames.add(content);
        } else if ("title".equals(bookTitle)) {
            bookTitles.add(content);
        } else if ("year".equals(authorName)) {
            publicationYears.add(Integer.parseInt(content));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("author".equals(localName)) {
            System.out.println("Authors: " + authorNames);
            authorNames.clear();
        } else if ("title".equals(localName)) {
            System.out.println("Book Titles: " + bookTitles);
            bookTitles.clear();
        } else if ("year".equals(localName)) {
            System.out.println("Publication Years: " + publicationYears);
            publicationYears.clear();
        }
    }
}