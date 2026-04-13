import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35794_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("data.xml"), new MyHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private String lastElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("book")) {
                System.out.println("Start element: " + qName);
            } else {
                System.out.println("Start element: " + qName + " inside " + lastElement);
                lastElement = qName;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("book")) {
                System.out.println("End element: " + qName);
            } else {
                System.out.println("End element: " + qName + " inside " + lastElement);
                lastElement = lastElement.equals("book") ? "" : lastElement;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElement.equals("book")) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        }
    }
}