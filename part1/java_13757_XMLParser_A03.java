import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_13757_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean nameFound = false;
    private boolean attributeFound = false;
    private boolean namespaceFound = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            nameFound = true;
        } else if (qName.equalsIgnoreCase("attribute")) {
            attributeFound = true;
        } else if (qName.equalsIgnoreCase("namespace")) {
            namespaceFound = true;
        }
        // ... continue handling other tags
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            if (!nameFound) {
                System.out.println("Security: Detected injection of 'name' tag");
            }
            nameFound = false;
        } else if (qName.equalsIgnoreCase("attribute")) {
            if (!attributeFound) {
                System.out.println("Security: Detected injection of 'attribute' tag");
            }
            attributeFound = false;
        } else if (qName.equalsIgnoreCase("namespace")) {
            if (!namespaceFound) {
                System.out.println("Security: Detected injection of 'namespace' tag");
            }
            namespaceFound = false;
        }
        // ... continue handling other tags
    }
}