import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24844_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("src/main/resources/sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {

        private boolean bElementName = false;
        private boolean bElementValue = false;
        private String currentValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bElementName = true;
                bElementValue = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("element")) {
                bElementName = false;
                bElementValue = false;
                System.out.println("Element Name: " + currentValue);
                System.out.println("Element Value: " + currentValue);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElementValue) {
                currentValue = new String(ch, start, length);
            }
        }
    }
}