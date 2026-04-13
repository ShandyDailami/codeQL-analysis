import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_30321_XMLParser_A08 {
    public static void main(String[] args) throws ParsingException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(new XMLReader(new CustomHandler()));
        sp.parse(new File("input.xml"));
    }

    private static class CustomHandler extends DefaultHandler {
        private boolean inPerson = false;
        private boolean inName = false;
        private boolean inAge = false;
        private String currentElement = "";

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (qName.equals("person")) {
                inPerson = true;
            } else if (qName.equals("name")) {
                inName = true;
            } else if (qName.equals("age")) {
                inAge = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                inPerson = false;
            } else if (qName.equals("name")) {
                inName = false;
            } else if (qName.equals("age")) {
                inAge = false;
            }
            currentElement = "";
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inPerson) {
                // handle person node
                System.out.println("Person Name: " + new String(ch, start, length));
            } else if (inName) {
                // handle name node
                System.out.println("Name: " + new String(ch, start, length));
            } else if (inAge) {
                // handle age node
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}