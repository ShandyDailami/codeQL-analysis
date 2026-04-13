import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLHandler;

import java.io.File;
import java.io.IOException;

public class java_04610_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");

        XMLHandler handler = new XMLHandler() {
            private String currentElementName;

            @Override
            public void startElement(String uri, String localName, String qName,
                                     org.xml.sax.Attributes attributes) throws SAXException {
                currentElementName = localName;
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (currentElementName != null) {
                    System.out.println("Found element: " + currentElementName);
                    currentElementName = null;
                }
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