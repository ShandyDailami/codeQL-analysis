import java.net.URL;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;

public class java_21344_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/sample.xml"); // replace with your XML URL
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler();
            parser.parse(url.openStream(), handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}