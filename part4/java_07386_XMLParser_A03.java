import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_07386_XMLParser_A03 extends DefaultHandler {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXXMLReaderImpl(xmlFile));
            parser.parse(null, new SAXXMLParser(), true);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {
        System.out.println("Start Prefix Mapping: " + prefix + " = " + uri);
    }

    @Override
    public void endPrefixMapping(String prefix) {
        System.out.println("End Prefix Mapping: " + prefix);
    }
}