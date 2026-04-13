import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_32914_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/file.xml";
        parseXML(xmlFilePath);
    }

    private static void parseXML(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            });
            reader.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("Parse exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O exception: " + e.getMessage());
        }
    }
}