import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_35415_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("resources/example.xml");
            XMLLoader loader = new XMLLoader(XMLParserExample.class.getClassLoader().getResourceAsStream(xmlFile.toString()));

            loader.setContentHandler(new DefaultHandler() {
                public void startDocument() throws SAXException {
                    System.out.println("Start of document");
                }

                public void endDocument() throws SAXException {
                    System.out.println("End of document");
                }

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start of element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End of element: " + qName);
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Character data: " + new String(ch, start, length));
                }
            });

            loader.parse(xmlFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}