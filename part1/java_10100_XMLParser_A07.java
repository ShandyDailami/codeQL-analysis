import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_10100_XMLParser_A07 {

    private DefaultHandler defaultHandler;

    public java_10100_XMLParser_A07() {
        defaultHandler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                // handle start elements
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                // handle end elements
           
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                // handle characters
            }

            public void error(SAXException e) {
                // handle errors
            }

            public void fatalError(SAXException e) {
                // handle fatal errors
            }

            public void warning(SAXParseException e) {
                // handle warnings
            }
        };
    }

    public void parseXML(String xmlFile) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser(defaultHandler);

            // Parsing the XML file
            saxParser.parse(xmlFile, defaultHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParserLegacy xmlParser = new XMLParserLegacy();
        xmlParser.parseXML("src/main/resources/sample.xml");
    }
}