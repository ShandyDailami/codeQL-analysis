import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.XMLEvent;
import org.xml.sax.entities.Entity;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_31579_XMLParser_A01 {

    public static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyHandler handler = new MyHandler();
        EntityResolver resolver = new EntityResolver() {
            public Entity resolveEntity(String publicId, String systemId)
                    throws SAXException, IOException {
                System.out.println("Resolving entity: " + systemId);
                // In this case, we're only going to resolve and return a dummy entity
                return new Entity("dummy", "dummy");
            }
        };
        SAXReader saxReader = new SAXReader();
        saxReader.setEntityResolver(resolver);
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new File("broken-access-control.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}