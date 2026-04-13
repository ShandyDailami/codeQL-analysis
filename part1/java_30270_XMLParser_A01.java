import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_30270_XMLParser_A01 {
    public static void main(String[] args) {
        parseXMLFile("data.xml");
    }

    private static void parseXMLFile(String fileName) {
        SAXHelper saxHelper = new SAXHelper() {
            public void startDocument() throws SAXException {
                System.out.println("Start of Document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of Document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.print("Start Element: " + qName);
                printElementAttributes(attributes);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            private void printElementAttributes(Attributes attributes) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("Attribute: " + attributes.getQName(i) + "= " + attributes.getValue(i));
                }
            }
        };

        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of Document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of Document");
            }

            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.print("Start Element: " + qName);
                printElementAttributes(attributes);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            org.xml.sax.helpers.XMLReaderFactory.newSAXHelper(fis, handler, saxHelper).parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}