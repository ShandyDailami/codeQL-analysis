import java.io.FileInputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.Access;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_05196_XMLParser_A01 {

    public static void main(String[] args) {
        String file = "myfile.xml"; // provide your xml file here
        parseFile(file);
    }

    private static void parseFile(final String file) {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End of document");
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start of element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End of element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            @Override
            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println("Start of prefix mapping: " + prefix + " -> " + uri);
            }

            @Override
            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println("End of prefix mapping: " + prefix);
            }
        });

        try {
            FileInputStream fis = new FileInputStream(file);
            AccessController.doPrivileged(new AccessControlPrivilegedAction() {
                public Access get() {
                    return Access.get(fis);
                }
            });
            reader.parse(new InputSource(fis));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}