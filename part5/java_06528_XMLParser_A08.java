import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerSupport;

import java.io.File;
import java.io.IOException;

public class java_06528_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DefaultHandlerSupport handler = new DefaultHandlerSupport() {
            @Override
            public void startElement(String uri, String localName, String qName,
                                     org.xml.sax.Attributes attributes) throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }
        };

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}