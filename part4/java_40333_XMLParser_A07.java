import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40333_XMLParser_A07 extends DefaultHandler {

    private StringBuilder data;

    public java_40333_XMLParser_A07() {
        data = new StringBuilder();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {
        data.append("<").append(qName);

        // Print out all attributes
        for (int i = 0; i < attributes.getLength(); i++) {
            data.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }

        data.append(">");
    }

    public void endElement(String uri, String localName, String qName)
        throws SAXException {
        data.append("</").append(qName).append(">");
    }

    public void characters(char[] ch, int start, int length)
        throws SAXException {
        data.append(ch, start, length);
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyXMLParser handler = new MyXMLParser();

        parser.parse("src/main/resources/example.xml", handler);

        System.out.println(handler.getData().toString());
    }

    public StringBuilder getData() {
        return data;
    }
}