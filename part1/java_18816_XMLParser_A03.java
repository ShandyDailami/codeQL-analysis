import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_18816_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("input.xml"), myHandler);
    }

    static class MyHandler extends DefaultHandler {

        boolean bPerson = false;
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bPerson = true;
            } else if (bPerson) {
                if (qName.equalsIgnoreCase("name")) {
                    bName = true;
                } else if (qName.equalsIgnoreCase("age")) {
                    bAge = true;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bPerson = false;
            } else if (bPerson && qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (bPerson && qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bPerson && bName && bAge) {
                String person = new String(ch, start, length);
                String name = person.trim();
                int age = Integer.parseInt(name);
                System.out.println("Name: " + name + ", Age: " + age);
            }
        }
    }
}