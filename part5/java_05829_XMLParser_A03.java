import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class java_05829_XMLParser_A03 {

    public static class MyHandler extends DefaultHandler {

        private boolean titleFound = false;
        private boolean bodyFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, java.util.Properties properties) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                titleFound = true;
            } else if (qName.equalsIgnoreCase("body")) {
                bodyFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                titleFound = false;
            } else if (qName.equalsIgnoreCase("body")) {
                bodyFound = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (titleFound) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (bodyFound) {
                System.out.println("Body: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            URI[] theURIs = { URI.create("http://localhost/test.dtd") };
            EntityResolver resolver = new EntityResolver() {
                public java.net.URI resolveEntity(String name) throws SAXException {
                    return theURIs[0];
                }
            };
            XMLReader theReader = XMLReaderFactory.createXMLReader(resolver);
            theReader.setFeature("http://xml.org/sax/features/namespaces", true);
            theReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            theReader.setFeature("http://xml.org/sax/features/validation", true);
            theReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            theReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            theReader.setContentHandler(new MyHandler());
            theReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}