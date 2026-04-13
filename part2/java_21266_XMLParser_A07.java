import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_21266_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // replace with your XML file
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        XMLParser parser = new XMLParser();
        DefaultHandler handler = new DefaultHandler() {
            boolean bName = false;
            boolean bAge = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("student")) {
                    bName = true;
                    bAge = true;
                } else if (bName && qName.equalsIgnoreCase("name")) {
                    bName = false;
                } else if (bName && qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bName) {
                    System.out.println("Name: " + new String(ch, start, length));
                } else if (bAge) {
                    System.out.println("Age: " + new String(ch, start, length));
                }
            }
        };

        try {
            XMLLoader loader = new XMLLoader(parser);
            loader.setContentHandler(handler);
            loader.load(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}