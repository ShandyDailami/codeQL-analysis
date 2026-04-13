import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_20168_XMLParser_A08 extends DefaultHandler {

    private boolean elementContent = false;
    private StringBuilder content = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if(qName.equalsIgnoreCase("element")) {
            elementContent = true;
        } else {
            if(elementContent) {
                content.append(qName);
                elementContent = false;
            } else {
                System.out.println("Unexpected element: " + qName);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if(qName.equalsIgnoreCase("element")) {
            // Processing the content here
            System.out.println("Content: " + content.toString());
            content.setLength(0);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if(elementContent) {
            content.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyXMLParser.parse("example.xml", new MyXMLHandler());
    }

}

class MyXMLParser {
    public static void parse(String fileName, DefaultHandler handler) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(Class.forName("org.xml.sax.InputSource").getField("SAX_SOURCE", true).get(null), handler);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}