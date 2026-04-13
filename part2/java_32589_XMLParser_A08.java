import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_32589_XMLParser_A08 {

    public static void parse(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        MyHandler handler = new MyHandler();
        saxParser.parse(new File(filePath), handler);
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName = false;
        private boolean bAttribute = false;
        private String currentElement;
        private String currentAttribute;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            bName = true;
            bAttribute = false;
            for (int i = 0; i < attributes.getLength(); i++) {
                currentAttribute = attributes.getQualifiedPrefix(i) + attributes.getLocalName(i);
                bAttribute = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement.equals(qName)) {
                if (bName) {
                    System.out.println("Element: " + qName);
                }
                if (bAttribute) {
                    System.out.println("Attribute: " + currentAttribute);
                }
                bName = false;
                bAttribute = false;
            }
        }
    }
}