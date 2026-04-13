import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16493_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder currentElement;
        private StringBuilder currentAttributeValue;

        @Override
        public void startElement(String uri, String localName, String qName, StringBuffer attributes) {
            currentElement = new StringBuilder(localName);
            System.out.println("Start element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            currentAttributeValue = new StringBuilder(new String(ch, start, length));
            System.out.println("Attribute value: " + new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (currentElement != null && currentAttributeValue != null) {
                System.out.println("End element: " + localName + " with attribute: " + currentAttributeValue);
            }
        }
    }
}