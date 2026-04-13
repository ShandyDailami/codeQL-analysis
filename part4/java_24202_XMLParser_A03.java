import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24202_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/test.xml"), new DefaultHandler());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private StringBuilder content = new StringBuilder();
        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            content.setLength(0);
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content.append(ch, start, length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if ("employee".equals(currentElement)) {
                System.out.println("Name: " + content.toString());
            } else if ("id".equals(currentElement)) {
                System.out.println("ID: " + content.toString());
            } else if ("salary".equals(currentElement)) {
                System.out.println("Salary: " + content.toString());
            }
        }
    }
}