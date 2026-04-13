import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XercesDOMParser;

public class java_37872_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(String xmlFile) {
        XMLParser parser = new XercesDOMParser();
        DefaultHandler handler = new DefaultHandler() {
            boolean bName = false;
            boolean bAge = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                if (qName.equalsIgnoreCase("person")) {
                    System.out.println("Name: " + attributes.getValue("name"));
                    System.out.println("Age: " + attributes.getValue("age"));
                    bName = true;
                    bAge = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equalsIgnoreCase("person")) {
                    bName = false;
                    bAge = false;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bName) {
                    System.out.print("Name: ");
                    bName = false;
                } else if (bAge) {
                    System.out.println("Age: " + new String(ch, start, length));
                    bAge = false;
                }
            }
        };

        try {
            parser.setDocumentBuilders(new DocumentBuilders());
            parser.setErrorHandler(new ErrorHandler() {
                @Override
                public void fatalError(SAXException e) throws SAXException {
                    throw e;
                }

                @Override
                public void warning(SAXWarning e) throws SAXException {
                    throw e;
                }
            });
            parser.parse(new FileInputStream(xmlFile), handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}