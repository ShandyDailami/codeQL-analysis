import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_13882_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            XMLReaderHandler handler = new XMLReaderHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class XMLReaderHandler implements org.xml.sax.ContentHandler {
    private boolean isInElement = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        isInElement = true;
        System.out.println(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            System.out.println(new String(ch, start, length));
        }
    }
}