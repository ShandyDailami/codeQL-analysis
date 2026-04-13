import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24550_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder currentValue;

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start of element: " + qName);
            currentValue = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
            System.out.println("Value: " + currentValue.toString());
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            currentValue.append(new String(ch, start, length));
        }

    }
}