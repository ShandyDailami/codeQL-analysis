import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_30583_XMLParser_A01 extends DefaultHandler {
    private StringBuilder data = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public String getData() {
        return data.toString();
    }
}

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xml = "<person><name>John</name><age>30</age></person>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyXMLHandler());

        parser.parse(new InputSource(new StringReader(xml)));

        System.out.println(parser.getProperty("xmlFiles.namespaces.1"));
        System.out.println(parser.getProperty("xmlFiles.namespaces.2"));
    }
}