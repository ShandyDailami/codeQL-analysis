import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_35150_XMLParser_A08 {
    public static void main(String[] args) {
        EntityResolver resolver = new CustomEntityResolver();
        SAXReaderFactory.getDefaultInstance().setEntityResolver(resolver);

        XMLReader reader = null;
        try {
            reader = SAXReaderFactory.newSAXReader();
            reader.setEntityResolver(resolver);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            reader.setContentHandler(handler);
            reader.parse(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}