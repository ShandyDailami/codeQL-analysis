import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_12108_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // replace with your XML file
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File(xmlFile), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAge = false;
        private String tempValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            }

            if (bName && qName.equalsIgnoreCase("name")) {
                tempValue = attributes.getValue("id");
                System.out.println("Name: " + tempValue);
                bName = false;
            }

            if (bAge && qName.equalsIgnoreCase("age")) {
                tempValue = attributes.getValue("id");
                System.out.println("Age: " + tempValue);
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
            }
        }
    }
}