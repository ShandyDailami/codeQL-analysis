import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_38846_XMLParser_A08 {
    private static class MyHandler extends DefaultHandler {
        private List<String> elements;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName)
                throws SAXException {
            currentElement = qName;
            elements = null;
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (elements == null) {
                elements = new String(ch, start, length);
            } else {
                elements.append(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (currentElement.equals(localName)) {
                System.out.println(elements);
            }
        }
    }

    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        File xmlFile = new File("input.xml");
        MyHandler handler = new MyHandler();
        try {
            XMLReader xmlReader = reader.getReader(xmlFile);
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new SAXSource(xmlReader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}