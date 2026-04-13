import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.XMLEvent;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.entities.StringList;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_19539_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml");
            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader(new EntityResolver() {
                @Override
                public Object getEntity(String url) throws SAXException, IOException {
                    if (url != null) {
                        // Here we're not using any external libraries, so we can't use a library for parsing entity references.
                        throw new UnsupportedOperationException();
                    }
                    return new StringList() {
                        @Override
                        public void add(String text) {
                            // No need to implement this method.
                        }

                        @Override
                        public int getSize() {
                            return 0;
                       
                        }

                        @Override
                        public String get(int index) {
                            return "";
                        }
                    };
                }
            });

            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, XMLEvent event) throws SAXException {
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println(new String(ch, start, length));
        }
    }
}