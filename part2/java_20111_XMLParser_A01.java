import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.xmlreader.XMLRPC;

import java.io.File;
import java.io.IOException;

public class java_20111_XMLParser_A01 {

    public static void main(String[] args) {
        // Reading the XML file
        File file = new File("input.xml");
        XMLReader xmlReader;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new ContentHandler());
            xmlReader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandler extends DefaultHandler {
        boolean bElement = false;
        String currentElement = "";
        String currentValue = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            bElement = true;
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                currentValue = new String(ch, start, length);
                bElement = false;
            } else {
                currentValue += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bElement = false;
            if (currentElement.equalsIgnoreCase("Employee")) {
                System.out.println("Employee Name: " + currentValue);
                System.out.println("Employee Age: " + currentValue);
            } else {
                System.out.println(currentElement + " : " + currentValue);
            }
        }
    }
}