import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XPPI;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_07400_XMLParser_A03 {
    private File xmlFile;

    public java_07400_XMLParser_A03(String xmlFilePath) {
        xmlFile = new File(xmlFilePath);
    }

    public void parseXML() {
        XMLParser parser = null;
        try {
            parser = XMLParser.newInstance();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return;
        }
        parser.setValidationMode(XMLParser.VALIDATION_MODE_STRICT);
        DefaultHandler handler = new MyHandler();
        try {
            parser.parse(xmlFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            System.out.println("Character content: " + content);
        }
    }

    public static void main(String[] args) {
        SAXParserExample saxParserExample = new SAXParserExample("src/main/resources/sample.xml");
        saxParserExample.parseXML();
    }
}