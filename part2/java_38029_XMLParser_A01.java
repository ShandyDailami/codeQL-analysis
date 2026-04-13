import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_38029_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            boolean isInElement = false;
            String currentElement = null;

            @Override
            public void startElement(String uri, String localName, String qName, java.util.Properties properties) throws SAXException {
                isInElement = true;
                currentElement = qName;
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                isInElement = false;
           
                if (isInElement) {
                    System.out.println("End element: " + currentElement);
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isInElement) {
                    System.out.println("Content: " + new String(ch, start, length));
                }
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.toURI().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}