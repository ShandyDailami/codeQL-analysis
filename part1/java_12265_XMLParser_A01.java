import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.SAXEntry;

import java.io.File;
import java.io.IOException;

public class java_12265_XMLParser_A01 {

    public static void main(String[] args) {
        SAXReaderFactory factory = new SAXReaderFactory();
        SAXEntry entry = factory.createSAXEntry();

        XMLReader reader = entry.getXMLReader();

        File inputFile = new File("input.xml");

        try {
            reader.setContentHandler(new XMLContentHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class XMLContentHandler implements javax.xml.parsers.SAXHandler {
        @Override
        public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
            System.out.println("Attributes: ");

            attributes.forEach(attr -> {
                System.out.println("Name: " + attr.getName() + ", Value: " + attr.getValue());
            });
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }
    }
}