import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_03242_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            SAXParserHandler handler = new SAXParserHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXParseException | IOException e) {
            e.printStackTrace();
        }
    }

    static class SAXParserHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;
        boolean bCountry = false;
        String name = null;
        String age = null;
        String country = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                return;
            }
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
                return;
            }
            if (qName.equalsIgnoreCase("age")) {
                bAge = true;
                return;
            }
            if (qName.equalsIgnoreCase("country")) {
                bCountry = true;
                return;
            }
            if (!bName && !bAge && !bCountry) {
                name = localName;
                bName = true;
                return;
            }
            if (bAge && !qName.equalsIgnoreCase("age")) {
                age = localName;
                bAge = false;
                return;
            }
            if (bCountry && !qName.equalsIgnoreCase("country")) {
                country = localName;
                bCountry = false;
                return;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Country: " + country);
                return;
            }
            if (!bName && !bAge && !bCountry) {
                return;
            }
            if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.println("Age: " + age);
                return;
            }
            if (bCountry && qName.equalsIgnoreCase("country")) {
                System.out.println("Country: " + country);
                return;
            }
        }
    }
}