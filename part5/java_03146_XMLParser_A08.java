import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_03146_XMLParser_A08 {
    public static void main(String[] args) {
        // Initialize entity resolver
        EntityResolver resolver = new EntityResolver() {
            public Object getEntity(String arg0) throws SAXException {
                // In real application, handle and return real entity.
                return null;
            }
        };

        try {
            // Create default handler
            DefaultHandler handler = new DefaultHandler() {
                public void startDocument() {
                    System.out.println("Start of document");
                }

                public void endDocument() {
                    System.out.println("End of document");
                }

                public void startElement(String arg0, String arg1, String arg2, List arg3) {
                    System.out.println("Start of element: " + arg1);
                }

                public void endElement(String arg0, String arg1, String arg2) {
                    System.out.println("End of element: " + arg1);
                }

                public void characters(char[] arg0, int arg1, int arg2) {
                    System.out.println("Characters: " + new String(arg0, arg1, arg2));
                }

                public void fatalError(SAXException arg0) {
                    System.out.println("Fatal error: " + arg0);
                }
            };

            // Create XMLReader with custom entity resolver
            XMLReader reader = XMLReaderFactory.createXMLReader(resolver);
            reader.setContentHandler(handler);

            // Read XML
            reader.parse(new File("sample.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}