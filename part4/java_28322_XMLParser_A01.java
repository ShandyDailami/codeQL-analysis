import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28322_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a SAXParserFactory instance
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

            // Create a SAXParser instance
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create a DefaultHandler instance
            DefaultHandler defaultHandler = new DefaultHandler() {
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
            };

            // Create a SAXSource instance
            SAXSource saxSource = new SAXSource(new SAXReader(defaultHandler), new File("input.xml"));

            // Create a XMLReader instance
            XMLReader xmlReader = saxParser.getXMLReader(saxSource);

            // Parse the XML file
            xmlReader.parse(new File("input.xml"));

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}