import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_18160_XMLParser_A07 extends DefaultHandler {

    private boolean bAuthFailure = false;
    private String currentElement = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if(qName.equals("AuthFailure")) {
            bAuthFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
        if(qName.equals("AuthFailure")) {
            bAuthFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bAuthFailure && currentElement != null) {
            String s = new String(ch, start, length);
            // Perform security-sensitive operation related to "AuthFailure"
            // For example, print out the sensitive data
            System.out.println("Sensitive Data: " + s);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("sample.xml"), myHandler);
    }
}