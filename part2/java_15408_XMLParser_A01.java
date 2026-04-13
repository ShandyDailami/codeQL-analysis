import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XercesSAXParser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class java_15408_XMLParser_A01 extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        // Uncomment the following line and change the content to suit your needs
        // Logger.getLogger(MySAXHandler.class.getName()).log(Level.INFO, "Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        // Uncomment the following line and change the content to suit your needs
        // Logger.getLogger(MySAXHandler.class.getName()).log(Level.INFO, "End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        // Uncomment the following line and change the content to suit your needs
        // Logger.getLogger(MySAXHandler.class.getName()).log(Level.INFO, "Characters: " + new String(ch, start, length));
    }
}

class MyXMLParser {

    public static void parseXMLFile(String filePath) {

        SAXParser saxParser = null;

        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser(new Properties());
        } catch (Exception e) {
            e.printStackTrace();
        }

        MySAXHandler saxHandler = new MySAXHandler();
        saxParser.parse(new File(filePath), saxHandler);
    }
}