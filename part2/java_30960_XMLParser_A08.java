import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.Xerces2SAXParser;
import org.xml.sax.parser.Xerces2XMLReader;
import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_30960_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a new instance of the Legacy XML Parser
            XMLParser parser = new SAXParserImpl();
            
            // Use a DocumentBuilderFactory to create a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse("input.xml");
            parser.parse(document, new DefaultHandler());

        } catch (ParserConfigurationException | SAXParseException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static class SAXParserImpl extends DefaultHandler implements SAXParser {
        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

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

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {
            System.out.println("Processing Instruction: " + target + ", " + data);
        }

        @Override
        public void setDocumentLocator(Locator locator) throws SAXException {
            System.out.println("Document Locator: " + locator.toString());
        }

        @Override
        public Locator getDocumentLocator() throws SAXException {
            System.out.println("Get Document Locator");
            return null;
        }

        @Override
        public boolean getFeature(String name) throws SAXException {
            System.out.println("Get Feature: " + name);
            return false;
        }

        @Override
        public void setEntityResolver(EntityResolver resolver) throws SAXException {
            System.out.println("Set Entity Resolver");
        }

        @Override
        public EntityResolver getEntityResolver() throws SAXException {
            System.out.println("Get Entity Resolver");
            return null;
        }
    }
}