import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_07201_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("sample.xml");
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(false, new MyHandler());
            saxParser.parse(fis, new DefaultHandler());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        public void startDocument() {
            System.out.println("Start of document");
        }

        public void endDocument() {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            System.out.println("Chars: " + new String(ch, start, length));
        }
    }
}