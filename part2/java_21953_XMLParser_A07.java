import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XSLTProcessor;
import org.xml.sax.parser.XSLTProcessorInitializeListener;
import org.xml.sax.xmlreader.XMLRPCReader;
import org.xml.sax.xmlreader.XMLReader;

import java.io.File;
import java.io.IOException;

public class java_21953_XMLParser_A07 {

    public static void main(String[] args) {
        XMLParserExample example = new XMLParserExample();
        example.parseXML("src/resources/sample.xml");
    }

    public void parseXML(String fileName) {
        File file = new File(fileName);
        XMLReader reader = null;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            reader.setFeature("http://xml.org/sax/features/external-dtd", false);

            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start Element: " + localName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End Element: " + localName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    System.out.println("Character Data: " + new String(ch, start, length));
                }
            };

            reader.setContentHandler(handler);
            reader.parse(file);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}