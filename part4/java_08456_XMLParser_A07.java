import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08456_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse(new File("example.xml"), xmlHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {

        boolean bName = false;
        boolean bValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("value")) {
                bValue = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bName) {
                bName = false;
                System.out.print("Name: ");
            } else if (bValue) {
                bValue = false;
                System.out.println();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bValue) {
                System.out.print(new String(ch, start, length));
            }
        }
    }
}