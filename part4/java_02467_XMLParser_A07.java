import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_02467_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("data.xml"), myHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bElement = false;
        boolean bAttribute = false;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            bElement = true;
            bAttribute = false;
            System.out.println("Start Element: " + qName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            bElement = false;
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bElement) {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        }

        private void printAttributes(org.xml.sax.Attributes attributes) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }
    }
}