import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18062_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Start parsing
            saxParser.parse(new File("sample.xml"), new XmlHandler());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implement SAX parsing here
    static class XmlHandler implements org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + localName);

            // Injecting code here
            // For example, print out all attributes
            if (attributes != null) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}