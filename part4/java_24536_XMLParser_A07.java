import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_24536_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);

            MyHandler handler = new MyHandler();
            saxParser.parse(new File("src/main/resources/sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isAuthFailure = false;
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0); // clear buffer each time a new element starts
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isAuthFailure && buffer.toString().contains("auth failure")) {
            // perform security sensitive operation
            System.out.println("Security sensitive operation performed!");
        }
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Ignore prefix mapping
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Ignore prefix mapping
    }

    public void setIsAuthFailure(boolean isAuthFailure) {
        this.isAuthFailure = isAuthFailure;
    }
}