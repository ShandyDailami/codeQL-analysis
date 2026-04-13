import java.io.File;
import java.util.logging.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_10333_XMLParser_A08 {

    private static Logger logger = Logger.getLogger(VanillaXMLParser.class.getName());

    public void parseFile(String fileName) {
        try {
            File file = new File(fileName);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            XMLHandler handler = new XMLHandler();
            reader.setContentHandler(handler);
            reader.parse(file);
        } catch (SAXException e) {
            logger.severe("SAXException: " + e.getMessage());
        } catch (Exception e) {
            logger.severe("Exception: " + e.getMessage());
        }
    }

    public class XMLHandler implements org.xml.sax.helpers.DefaultHandler {

        @Override
        public void startDocument() throws SAXException {
            logger.info("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            logger.info("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            logger.info("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            logger.info("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String data = new String(ch, start, length).trim();
            if (!data.isEmpty()) {
                logger.info("Data: " + data);
            }
        }

        @Override
        public void warning(SAXException e) {
            logger.warning("SAX Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXException e) {
            logger.warning("SAX Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            logger.severe("Fatal SAX Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        VanillaXMLParser parser = new VanillaXMLParser();
        parser.parseFile("sample.xml");
    }
}