import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_23422_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "src/main/resources/test.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean elementName = false;
        private boolean elementContent = false;
        private String currentElementContent = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            elementName = true;
            elementContent = false;
            currentElementContent = "";
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            elementName = false;
            elementContent = true;
            System.out.println(qName + ": " + currentElementContent);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (elementName) {
                currentElementContent = new String(ch, start, length);
            }
        }

    }
}