import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05148_XMLParser_A07 extends DefaultHandler {

    private boolean bAuthFailure = false;
    private StringBuffer s;

    public java_05148_XMLParser_A07() {
        s = new StringBuffer();
    }

    @Override
    public void startDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void endDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        s.setLength(0);
        if (qName.equals("AuthFailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do nothing
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        s.append(ch, start, length);
        if (bAuthFailure && s.toString().contains("password")) {
            // This is a security sensitive operation
            System.out.println("AuthFailure: Password detected!");
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(Class.forName("com.example.MyXML").getResourceAsStream("sample.xml"), new MyXMLParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}