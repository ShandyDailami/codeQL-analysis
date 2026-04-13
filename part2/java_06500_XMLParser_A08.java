import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XercesSAXParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class java_06500_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            InputStream xmlStream = LegacyXMLParser.class.getResourceAsStream("/sample.xml");
            parseXML(xmlStream);
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(InputStream xmlStream) throws IOException, SAXException, ParserConfigurationException {
        XMLParser parser = new XercesSAXParser();
        parser.setContentHandler(new SAXHandler());
        parser.parse(xmlStream);
    }

    private static class SAXHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}