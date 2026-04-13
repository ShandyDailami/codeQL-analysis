import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_34211_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            parser.parse(new File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bTag = false;
    private String currElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currElement = qName;
        bTag = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
        currElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            String content = new String(ch, start, length);
            // Here you can use the content to do your security-sensitive operations.
            // For example, you can check if the content contains any command or payload
            // injection attempts, and if so, throw an exception or log an alert.
            if (content.contains("command")) {
                throw new SecurityException("Command injection attempt detected");
            }
        }
    }
}