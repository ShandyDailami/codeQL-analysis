import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_17200_XMLParser_A01 {

    public static void main(String[] args) {

        File xmlFile = new File("yourXmlFile.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(myHandler);

            saxParser.setFeature("http://xml.org/sax/features/external-parametric-entity-ref", false);

            saxParser.parse(xmlFile, myHandler);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
        }

        @Override
        public void error(SAXParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}