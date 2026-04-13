import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_03091_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<root><element>Content</element></root>";
        MySAXHandler handler = new MySAXHandler();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new InputSource(new StringReader(xml)));
            parser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}

class MySAXHandler extends DefaultHandler {
    private boolean elementFound = false;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            elementFound = true;
            currentElement = qName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("root")) {
            if (!elementFound) {
                System.out.println("No element found!");
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementFound) {
            String content = new String(ch, start, length);
            System.out.println("Element content: " + content);
            elementFound = false;
        }
    }
}