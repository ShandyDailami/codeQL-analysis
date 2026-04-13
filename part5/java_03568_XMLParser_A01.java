import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_03568_XMLParser_A01 {

    private static class MyHandler extends DefaultHandler {
        private List<String> elements;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            elements = null;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement.equals("name")) {
                elements = List.of("Mr.", "Mrs.", "Ms.", "Dr.", "Prof.");
            }
            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentElement != null && elements != null) {
                String value = new String(ch, start, length);
                System.out.println(currentElement + ": " + value);
            }
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        File inputFile = new File("src/main/resources/input.xml");
        parser.parse(inputFile, MyHandler.class);
    }
}