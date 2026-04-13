import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_19909_XMLParser_A07 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/example.xml";
        File xmlFile = new File(fileName);

        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
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