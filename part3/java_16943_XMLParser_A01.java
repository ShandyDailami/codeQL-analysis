import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;
import org.xml.sax.parser.XMLErrorHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class java_16943_XMLParser_A01 {

    public static void main(String[] args) {
        URL url = new File("sample.xml").toURI().toURL();
        XMLParser parser = new XMLLoader(url, new XMLErrorHandler() {
            @Override
            public void warning(SAXParseException e) {
                System.out.println("SAX warning: " + e.getMessage());
            }

            @Override
            public void error(SAXParseException e) {
                System.out.println("SAX error: " + e.getMessage());
            }

            @Override
            public void fatalError(SAXParseException e) {
                System.out.println("SAX fatal error: " + e.getMessage());
            }
        });

        parser.setContentHandler(new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End document");
            }

            @Override
            public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qualifiedName);
            }

            @Override
            public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
                System.out.println("End element: " + qualifiedName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        });

        try {
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}