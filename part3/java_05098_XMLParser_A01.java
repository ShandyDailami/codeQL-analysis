import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerSupport;

import java.io.File;
import java.io.IOException;

public class java_05098_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("books.xml"); // replace with your xml file
            XMLReader reader = XMLReaderFactory.createXMLReader();

            reader.setContentHandler(new DefaultHandlerSupport(new DefaultHandler()) {
                @Override
                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start Element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + qName);
                }
            });

            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}