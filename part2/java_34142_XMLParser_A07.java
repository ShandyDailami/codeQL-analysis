import java.net.URL;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34142_XMLParser_A07 extends DefaultHandler {

    private boolean authFailure = false;
    private StringBuffer buffer = new StringBuffer();
    private List list;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
            return;
        }
        if (authFailure) {
            list.add(buffer.toString());
            buffer.setLength(0);
            authFailure = false;
        }
        buffer.append(localName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = false;
        }
        if (authFailure) {
            list.add(buffer.toString());
            buffer.setLength(0);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authFailure) {
            buffer.append(ch, start, length);
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XmlAuthFailureParser xp = new XmlAuthFailureParser();
        sp.setContentHandler(xp);

        URL url = new URL("http://example.com/authFailure.xml");
        sp.parse(url.openStream(), xp);

        List list = xp.list;

        // Here you can access and manipulate the list of authFailures.
    }
}