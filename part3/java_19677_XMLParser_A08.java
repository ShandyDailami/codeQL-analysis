import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLRPCReader;
import org.xml.sax.xmlreader.XMLSecurityHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_19677_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("books.xml");
            XMLSecurityHandler securityHandler = new XMLSecurityHandler() {
                @Override
                public void fatalError(SAXParseException e) throws SAXException {
                    System.out.println("Fatal Error: " + e.getMessage());
                }

                @Override
                public void error(SAXParseException e) throws SAXException {
                    System.out.println("Error: " + e.getMessage());
                }

                @Override
                public void warning(SAXParseException e) throws SAXException {
                    System.out.println("Warning: " + e.getMessage());
                }

                @Override
                public void info(SAXParseException e) throws SAXException {
                    System.out.println("Info: " + e.getMessage());
                }
            };

            XMLReader reader = XMLReaderFactory.createXMLReader(securityHandler);
            DefaultHandler defaultHandler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            };

            reader.setContentHandler(defaultHandler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            System.out.println("Parsing Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }
}