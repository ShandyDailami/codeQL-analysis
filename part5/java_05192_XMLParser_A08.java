import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLParserFactory;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

public class java_05192_XMLParser_A08 {
    private static final String XML_FILE_PATH = "C:\\path\\to\\your\\file.xml"; // Path to your XML file

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE_PATH);

        if (!xmlFile.exists()) {
            throw new InvalidParameterException("XML file does not exist!");
        }

        XMLParserFactory parserFactory = XMLParserFactory.newInstance();

        try {
            XMLParser parser = parserFactory.newSAXParser(xmlFile.toURI().toString());
            MyHandler handler = new MyHandler();
            parser.setContentHandler(handler);

            // Start parsing
            parser.parse(xmlFile.toURI().toString());
        } catch (IOException e) {
            System.out.println("Error while reading the XML file!");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Error while parsing the XML file!");
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bNode;
        private String currElement;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of the document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of the document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currElement = qName;
            bNode = true;
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
            bNode = false;
            currElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bNode) {
                System.out.println("Element: " + currElement + ", Text: " + new String(ch, start, length));
            }
        }
    }
}