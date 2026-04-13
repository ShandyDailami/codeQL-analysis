import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_23774_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(new File("input.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (qName.equals("person")) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String value = new String(ch, start, length).trim();

            if (bName && currentElement.equals("name")) {
                System.out.println("Name: " + value);
                bName = false;
            } else if (bAge && currentElement.equals("age")) {
                System.out.println("Age: " + value);
                bAge = false;
            }
        }
    }
}