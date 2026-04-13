import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_14846_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("yourXmlFile.xml");
        SAXParserHandler handler = new SAXParserHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler implements org.xml.sax.ContentHandler {
    private boolean isInElement = false;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            // Process the text here.
            // For example, you might print it to the console.
            System.out.println("Text in element: " + new String(ch, start, length));
        }
    }
}