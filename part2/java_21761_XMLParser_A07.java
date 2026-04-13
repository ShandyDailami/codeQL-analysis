import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_21761_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<root><element>Content</element></root>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(true); // Enable validation
            XMLHandler myHandler = new XMLHandler();
            saxParser.parse(new InputSource(new StringReader(xml)), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {
    boolean element = false;
    boolean content = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            element = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element) {
            content = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            element = false;
        } else if (content) {
            System.out.println(new String(ch, start, length));
            content = false;
        }
    }
}