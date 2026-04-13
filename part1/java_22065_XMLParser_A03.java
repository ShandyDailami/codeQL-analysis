import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_22065_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}

class SAXHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        } else if (bName) {
            System.out.print("Name: " + localName);
            bName = false;
        } else if (bAge) {
            System.out.print(", Age: " + attributes.getValue(localName));
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName || bAge) {
            System.out.print(new String(ch, start, length));
        }
    }

}