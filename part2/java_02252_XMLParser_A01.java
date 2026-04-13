import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_02252_XMLParser_A01 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();

    public List<String> getTags() {
        return tags;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        tags.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Do nothing here, as we're only interested in tag names
    }
}

public class Main {
    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();

        // Use a SAX parser here, but if you use an external library, you'll need to use
        // a `XmlReader` or `XmlStreamReader` instead, and call `parse` method with
        // `EventHandler` and `DTDHandler` as the second parameter.
        //
        // For instance, with `javax.xml.parsers.SAXParserFactory`:
        // `SAXParserFactory.newInstance().newSAXParser(new InputSource(new FileInputStream("input.xml")), parser)`

        // Use a DOM parser here, but if you use an external library, you'll need to use
        // a `DocumentBuilderFactory` and `Document` objects:
        // `DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        // Document doc = dBuilder.parse("input.xml")`

        // For security sensitive operations, always ensure that your SAX parser is not
        // vulnerable to a Denial of Service attack. Make sure to only call `parse` method on
        // a `SAXSource` or `InputSource` that you trust.
    }
}