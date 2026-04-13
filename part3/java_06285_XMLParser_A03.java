import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.logging.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06285_XMLParser_A03 {
    private static final Logger logger = Logger.getLogger(XMLParser.class.getName());

    public void parse(String filename) throws InvalidParameterException {
        if (filename == null || filename.isEmpty()) {
            throw new InvalidParameterException("File name cannot be null or empty");
        }

        File xmlFile = new File(filename);

        if (!xmlFile.exists()) {
            throw new InvalidParameterException("File does not exist: " + filename);
        }

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse(xmlFile, xmlHandler);

        } catch (IOException e) {
            logger.severe("IOException while parsing the XML file: " + e.getMessage());

        } catch (SAXException e) {
            logger.severe("SAXException while parsing the XML file: " + e.getMessage());

        }
    }

    private class XMLHandler extends DefaultHandler {
        private boolean bTag = false;
        private StringBuilder data = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTag = true;
            data.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;

            if (bTag) {
                logger.info("Element: " + qName + ", Data: " + data.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                data.append(ch, start, length);
            }
        }
    }
}