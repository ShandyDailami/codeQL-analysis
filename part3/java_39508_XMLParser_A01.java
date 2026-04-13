import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_39508_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create an instance of MyHandler
            MyHandler handler = new MyHandler();

            // Create an instance of XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Set the handler for element events
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(new File("example.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean inElement;

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        inElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End element: " + qName);
        inElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (inElement) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}