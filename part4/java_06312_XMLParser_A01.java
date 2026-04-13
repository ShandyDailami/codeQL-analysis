import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06312_XMLParser_A01 extends DefaultHandler {
    private StringBuilder data;

    @Override
    public void startDocument() throws SAXException {
        data = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.append("<").append(qName);

        // Add attributes if any
        for(int i = 0; i < attributes.getLength(); i++) {
            data.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }

        data.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        data.append("</").append(qName).append(">");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(data.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // ignore character data
    }
}

public class MyXMLParser {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyXMLHandler());

            // Parse your XML file here.
            // parser.parse("path/to/your/xml/file.xml", MyXMLHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}