import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;
import org.xml.sax.handlers.DefaultHandler;

public class java_32400_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // replace with your xml file

        // create a new SAX parser
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // set the content handler
        reader.setContentHandler(new ContentHandler());

        // parse the XML file
        try {
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

// define a content handler
class ContentHandler extends DefaultHandler {
    private boolean isName;
    private String name;

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        isName = true;
        name = qualifiedName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        isName = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            System.out.println(name);
        }
    }
}