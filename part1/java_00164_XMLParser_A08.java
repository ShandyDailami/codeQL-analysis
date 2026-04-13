import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_00164_XMLParser_A08 {
    public static void main(String[] args) {
        SAXHandler handler = new SAXHandler();
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File("example.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private boolean bId = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
            bId = true;
        } else if (bName) {
            System.out.print("Name: ");
            bName = false;
        } else if (bAge) {
            System.out.print("Age: ");
            bAge = false;
        } else if (bId) {
            System.out.print("ID: ");
            bId = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.println(new String(ch, start, length));
        } else if (bAge) {
            System.out.println(new String(ch, start, length));
        } else if (bId) {
            System.out.println(new String(ch, start, length));
        }
    }
}