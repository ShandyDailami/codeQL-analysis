import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34665_XMLParser_A08 extends DefaultHandler {

    private String lastElement;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        lastElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && lastElement.equals("A08_IntegrityFailure")) {
            String integrityFailure = new String(ch, start, length);
            System.out.println("Integrity Failure: " + integrityFailure);
        } else {
            System.out.print("Non-A08_IntegrityFailure content: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        org.xml.sax.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(true);
        saxParser.parse("src/main/resources/example.xml", new MyXMLHandler());
    }
}