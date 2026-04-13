import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_07899_XMLParser_A03 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/example.xml";
        File xmlFile = new File(filePath);

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(xmlFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean isName = false;
        boolean isAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("person")) {
                System.out.println("Person Name: " + attributes.getValue("name"));
                System.out.println("Person Age: " + attributes.getValue("age"));
                isName = true;
                isAge = true;
            } else if (qName.equals("name")) {
                isName = true;
            } else if (qName.equals("age")) {
                isAge = true;
            }
        }

        @Override
        public java_07899_XMLParser_A03(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                isName = false;
                isAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                System.out.println("Person Name: " + new String(ch, start, length));
                isName = false;
            } else if (isAge) {
                System.out.println("Person Age: " + new String(ch, start, length));
                isAge = false;
            }
        }
    }
}