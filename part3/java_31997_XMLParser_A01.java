import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31997_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("sample.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bTitle = false;
    boolean bLink = false;
    String title = null;
    String link = null;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("article")) {
            bTitle = true;
            bLink = false;
        } else if (qName.equalsIgnoreCase("title")) {
            bTitle = true;
            bLink = false;
        } else if (qName.equalsIgnoreCase("link")) {
            bTitle = false;
            bLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("article")) {
            System.out.println("Article: " + title);
            System.out.println("Link: " + link);
            bTitle = false;
            bLink = false;
        } else if (qName.equalsIgnoreCase("title")) {
            bTitle = false;
        } else if (qName.equalsIgnoreCase("link")) {
            bLink = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTitle) {
            title = new String(ch, start, length);
        } else if (bLink) {
            link = new String(ch, start, length);
        }
    }
}