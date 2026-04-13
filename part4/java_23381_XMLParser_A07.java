import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_23381_XMLParser_A07 extends DefaultHandler {
    private boolean authFailure = false;

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        parser.parse();
    }

    private void parse() {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse("src/main/resources/authFailure.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        if (authFailure) {
            System.out.println("Auth Failure detected in the XML file");
        } else {
            System.out.println("No Auth Failure detected in the XML file");
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = false;
        }
    }
}