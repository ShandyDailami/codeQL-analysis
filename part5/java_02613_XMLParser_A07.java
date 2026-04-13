import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.parser.SAXParser;
import javax.xml.parser.SAXParserFactory;
import javax.xml.parsers.AtomicParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02613_XMLParser_A07 extends DefaultHandler {

    private boolean bAuthenticationFailure = false;

    public static void main(String[] args) {
        String urlStr = "http://example.com/myfile.xml";
        try {
            URL url = new URL(urlStr);
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(new AtomicParser(saxFactory));

            MyXMLParser handler = new MyXMLParser();
            saxParser.parse(url.openStream(), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authentication")) {
            bAuthenticationFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authentication")) {
            if (bAuthenticationFailure) {
                System.out.println("Authentication failure detected.");
                // Handle authentication failure here.
            } else {
                System.out.println("Authentication success.");
                // Handle authentication success here.
            }
            bAuthenticationFailure = false;
        }
    }
}