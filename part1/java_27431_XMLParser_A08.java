import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_27431_XMLParser_A08 {

    public static void parse(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new File(filePath), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {

        boolean bAddress = false;
        boolean bName = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("address")) {
                bAddress = true;
            } else if (qName.equalsIgnoreCase("name")) {
                bName = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("address")) {
                bAddress = false;
            } else if (qName.equalsIgnoreCase("name")) {
                bName = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAddress) {
                System.out.println("Address: " + new String(ch, start, length));
            } else if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }
        }
    }
}