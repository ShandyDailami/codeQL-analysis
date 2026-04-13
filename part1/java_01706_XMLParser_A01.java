import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_01706_XMLParser_A01 {

    public static class MyHandler extends DefaultHandler {

        private String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            currentElement = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentElement != null && currentElement.equals(qName)) {
                String value = new String(ch, start, length);
                System.out.println("Value of element " + currentElement + " is " + value);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}