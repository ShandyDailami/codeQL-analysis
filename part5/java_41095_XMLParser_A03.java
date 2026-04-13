import java.io.File;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;

public class java_41095_XMLParser_A03 extends DefaultHandler {
    private boolean inElement = false;
    private String currentElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        inElement = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inElement) {
            // Check for injection attacks. Here we only check for double quotes.
            if (currentElement != null && (currentElement.equals("username") || currentElement.equals("password"))
                    && new String(ch, start, length).contains("\"\"")) {
                System.out.println("[WARNING] Detected injection attack in " + currentElement);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
        inElement = false;
    }

    public static void main(String[] args) {
        XMLParser parser = XMLParser.newInstance();
        parser.setErrorHandler(new XMLErrorHandler() {
            public void warning(SAXParseException e) {
            }

            public void error(SAXParseException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }

            public void fatalError(SAXParseException e) {
                System.out.println("[FATAL ERROR] " + e.getMessage());
            }
        });

        try {
            parser.parse(new File("samples/sample.xml"), MySAXHandler.class.getCanonicalName());
        } catch (IOException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}