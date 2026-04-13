import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_24441_XMLParser_A07 extends DefaultHandler {
    private boolean isUser = false;
    private boolean isPass = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            isUser = true;
        } else if (qName.equalsIgnoreCase("pass")) {
            isPass = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("user")) {
            isUser = false;
        } else if (qName.equalsIgnoreCase("pass")) {
            isPass = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUser) {
            System.out.println("User: " + new String(ch, start, length));
        } else if (isPass) {
            System.out.println("Password: " + new String(ch, start, length));
        }
    }
}

public class XmlAuthFailureSAX {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("auth_failure.xml"), new XmlAuthFailureHandler());
    }
}