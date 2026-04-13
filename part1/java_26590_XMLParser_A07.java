import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26590_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/main/resources/data.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder buffer;

    MyHandler() {
        buffer = new StringBuilder();
    }

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String data = buffer.toString();
        // Add your security-sensitive operations here.
        // For example, check if the password matches a pre-defined pattern.
        if (data.equals("your_password")) {
            System.out.println("Authentication failure detected");
        } else {
            System.out.println("Passwords match: " + data);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }
}