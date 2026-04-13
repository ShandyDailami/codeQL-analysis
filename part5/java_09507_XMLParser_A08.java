import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.Entries;
import org.xml.sax.parsers.SAXParser;

import java.io.File;
import java.io.IOException;

public class java_09507_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");

        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        XMLReader reader = XMLReaderFactory.createXMLReader();

        SAXHandler handler = new SAXHandler();
        reader.setContentHandler(handler);

        try {
            reader.parse(xmlFile);
            if(handler.isValid()) {
                System.out.println("XML file is valid.");
            } else {
                System.out.println("XML file is invalid.");
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements ContentHandler {
    private boolean valid;

    @Override
    public void startDocument() {
        valid = true;
    }

    @Override
    public void endDocument() {
        // no-op
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // no-op
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // no-op
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // no-op
    }

    public boolean isValid() {
        return valid;
    }
}