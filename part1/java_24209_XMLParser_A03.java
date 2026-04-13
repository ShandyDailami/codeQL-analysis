import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_24209_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parse(xmlFile);
    }

    public static void parse(File xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                // Do nothing for now.
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                // Do nothing for now.
           
            }

            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                // Do nothing for now.
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}