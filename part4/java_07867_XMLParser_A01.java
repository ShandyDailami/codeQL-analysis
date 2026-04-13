import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;

public class java_07867_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserImpl parser = new SAXParserImpl();
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(parser);

        try {
            reader.parse("src/main/resources/example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserImpl implements SAX.Handler {
    boolean isTitleElement = true;
    String title = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("title".equals(qName)) {
            isTitleElement = true;
        } else {
            if (isTitleElement) {
                title += localName;
                isTitleElement = false;
            } else {
                System.out.println(localName + " : " + attributes.getValue(""));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("title".equals(qName)) {
            System.out.println("Book title: " + title);
            title = "";
        }
    }

    @Override
    public void characters(String uri, String localName, String qName, String value) throws SAXException {
        // Do nothing
    }
}