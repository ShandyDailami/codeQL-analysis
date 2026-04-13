import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_00665_XMLParser_A01 {

    // SAX parser
    public void parseXML(String file) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            // Set access controls
            saxParser.getXMLReader().setFeature("http://xml.org/sax/features/external-general-entities", false);
            saxParser.getXMLReader().setFeature("http://xml.org/sax/features/external-dtd", false);

            // Set a custom handler
            saxParser.setContentHandler(new XMLContentHandler());

            // Parse the XML
            saxParser.parse(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler for the SAX parser
    private class XMLContentHandler extends DefaultHandler {
        private boolean bName;
        private boolean bAge;

        public java_00665_XMLParser_A01() {
            bName = false;
            bAge = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                System.out.println("Name: " + localName);
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + attributes.getValue(0));
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
            }
        }
    }
}