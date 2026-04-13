import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14236_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new XMLHandler());
            saxParser.parse(new File("src/main/resources/example.xml"), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }
}