import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_37032_XMLParser_A08 extends DefaultHandler {
    private List<String> names = new ArrayList<>();

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        // replace this with your xml file
        parser.parse("src/main/resources/test.xml");
    }

    private void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new SAXContentHandler(this));
            parser.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("name".equals(qName)) {
            names.add(attributes.getValue("id"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // nothing to do here
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // nothing to do here
    }
}