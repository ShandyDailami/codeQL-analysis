import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_39863_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }

    }

    public static void main(String[] args) {
        String xmlFile = "src/test.xml";  // specify your xml file here

        SAXParser saxParser = null;
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser(new InputSource(new File(xmlFile)));
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
            return;
        }

        MyHandler myHandler = new MyHandler();
        saxParser.parse(xmlFile, myHandler);
    }
}