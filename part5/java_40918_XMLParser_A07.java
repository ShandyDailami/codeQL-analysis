import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLScanner;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_40918_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");

        try {
            SAXParserHandler handler = new SAXParserHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);

            reader.parse(xmlFile.toURI().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends DefaultHandler {
    private String currentElement;
    private boolean isInElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        isInElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
        isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            // Ignore XML tags
            return;
        }

        String content = new String(ch, start, length);
        // Do something with the content
    }
}