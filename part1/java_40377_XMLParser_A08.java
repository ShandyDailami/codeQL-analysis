import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicErrorHandler;

import java.io.File;
import java.io.IOException;

public class java_40377_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println("Parsing document...");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("Document parsed successfully.");
            }

            @Override
            public void startElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String value = new String(ch, start, length);
                System.out.println("Character data: " + value);
            }

            @Override
            public void error(SAXParseException e) {
                System.out.println("SAXException: " + e.getMessage());
            }

            @Override
            public void fatalError(SAXParseException e) {
                System.out.println("Fatal SAXParseException: " + e.getMessage());
            }

            @Override
            public void warning(SAXParseException e) {
                System.out.println("SAXParseException: " + e.getMessage());
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(new BasicErrorHandler());
            reader.parse(xmlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}