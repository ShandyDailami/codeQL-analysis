import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_33076_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                                     org.xml.sax.Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                throws SAXException {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length)
                throws SAXException {
                String content = new String(ch, start, length);
                System.out.println("Content: " + content);
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}