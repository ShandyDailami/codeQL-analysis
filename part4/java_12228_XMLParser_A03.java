import java.io.File;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;

public class java_12228_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            XMLReader parser = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAAPHandler();
            parser.setContentHandler(handler);
            parser.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAAPHandler extends DefaultHandler {

        boolean bNodeFound = false;
        String thisNode = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bNodeFound = true;
            thisNode = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bNodeFound = false;
            thisNode = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bNodeFound) {
                System.out.println(thisNode);
            }
        }

    }

}