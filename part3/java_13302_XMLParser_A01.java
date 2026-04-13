import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.Entity;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_13302_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "resources/data.xml";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String file) {
        EntityResolver resolver = new EntityResolver() {
            public Entity getEntity(String publicId, String systemId) throws SAXException, IOException {
                return null;
            }
        };

        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of document");
            }

            public void startElement(String namespaceURI, String localName, String qualifiedName, String[] attributes) throws SAXException {
                System.out.println("Start of element: " + qualifiedName);
                for (int i = 0; i < attributes.length; i++) {
                    System.out.println("Attribute: " + attributes[i]);
                }
            }

            public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
                System.out.println("End of element: " + qualifiedName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setEntityResolver(resolver);
            reader.parse(new File(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}