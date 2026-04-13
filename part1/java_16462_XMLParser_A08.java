import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16462_XMLParser_A08 extends DefaultHandler {

    private boolean isTitle = false;
    private boolean isLink = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("title")) {
            isTitle = true;
        }
        if (qName.equals("link")) {
            isLink = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isTitle) {
            System.out.println("Title: " + new String(ch, start, length));
            isTitle = false;
        }
        if (isLink) {
            System.out.println("Link: " + new String(ch, start, length));
            isLink = false;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("books.xml"), new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}