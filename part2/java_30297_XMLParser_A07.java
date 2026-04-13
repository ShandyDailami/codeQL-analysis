import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.StringReader;

public class java_30297_XMLParser_A07 {

    public static void main(String[] args) {
        parseXML("<data>Sample text</data>");
    }

    public static void parseXML(String xmlString) {
        SAXReader saxReader = new SAXReader();
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyContentHandler(xmlString));
            xmlReader.parse(new StringReader(xmlString));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static class MyContentHandler implements ContentHandler {
        private String xmlData;

        public java_30297_XMLParser_A07(String xmlData) {
            this.xmlData = xmlData;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
            xmlData = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
            System.out.println("Data: " + xmlData);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
            xmlData += new String(ch, start, length);
        }
    }
}