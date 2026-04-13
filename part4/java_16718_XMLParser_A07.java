import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_16718_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        LegacyHandler handler = new LegacyHandler();
        XMLReader reader = parser.getXMLReader();
        reader.setContentHandler(handler);

        try {
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class LegacyHandler extends DefaultHandler {
    private boolean isName = false;
    private boolean isAttribute = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("name")) {
            isName = true;
        }

        if (isName) {
            System.out.print("Name: ");
            isName = false;
        } else if (qName.equals("attribute")) {
            isAttribute = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            System.out.println(new String(ch, start, length));
        } else if (isAttribute) {
            System.out.print("Attribute: ");
            isAttribute = false;
        }
    }
}