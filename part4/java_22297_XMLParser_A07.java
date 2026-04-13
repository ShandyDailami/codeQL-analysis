import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_22297_XMLParser_A07 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();
    private StringBuffer buffer = new StringBuffer();

    public List<String> getTags() {
        return tags;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        tags.add(qName);
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        tags.remove(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        buffer.append(content);
        System.out.println("Characters: " + content);
    }

    @Override
    public void warning(SAXException e) throws SAXException {
        System.out.println("SAX warning: " + e.getMessage());
    }

    @Override
    public void error(SAXException e) throws SAXException {
        System.out.println("SAX error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAXException {
        System.out.println("Fatal SAX error: " + e.getMessage());
    }
}

public class Main {
    public static void main(String[] args) {
        String xml = "<root><element1>content1</element1><element2>content2</element2></root>";
        MyXMLHandler handler = new MyXMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(new InputSource(new StringReader(xml)));

            List<String> tags = handler.getTags();
            System.out.println("Tags: " + tags);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}