import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_15630_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // specify your XML file
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a new MyHandler to handle XML events
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(xmlFile);

            // Print the parsed data
            System.out.println(handler.getData());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {
    private String data;

    public void startDocument() throws SAXException {
        data = "";
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        // Nothing to do here
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Nothing to do here
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        data += new String(ch, start, length);
    }

    public void endDocument() {
        // Nothing to do here
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Nothing to do here
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        // Nothing to do here
    }

    public String getData() {
        return data;
    }
}