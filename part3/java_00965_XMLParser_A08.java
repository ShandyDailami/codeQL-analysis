import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_00965_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String xmlFile) {
        DefaultHandler handler = new DefaultHandler() {

            boolean bName = false;
            boolean bAge = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                if (qName.equalsIgnoreCase("name")) {
                    bName = true;
                } else if (qName.equalsIgnoreCase("age")) {
                    bAge = true;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bName) {
                    System.out.println("Name: " + new String(ch, start, length));
                    bName = false;
                } else if (bAge) {
                    System.out.println("Age: " + new String(ch, start, length));
                    bAge = false;
                }
            }
        };

        try {
            XMLParser parser = XMLLoader.getInstance().getSAXParser();
            parser.setContentHandler(handler);
            parser.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}