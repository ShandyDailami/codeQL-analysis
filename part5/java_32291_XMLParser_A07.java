import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32291_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/main/resources/example.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
       
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name : " + bName + ", Age : " + bAge);
                bName = false;
                bAge = false;
            } else if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println();
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (bName) {
                System.out.print("Name : ");
                System.out.println(new String(chars, start, length));
            } else if (bAge) {
                System.out.print("Age : ");
                System.out.println(new String(chars, start, length));
            }
        }
    }
}