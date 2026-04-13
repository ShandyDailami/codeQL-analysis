import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_12392_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuffer buffer;
    private String elementName;

    public java_12392_XMLParser_A03() {
        buffer = new StringBuffer();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        elementName = localName;
        buffer.setLength(0);
    }

    public void endElement(String uri, String localName, String qName) {
        // Handle element here
        System.out.println(elementName + ": " + buffer.toString());
    }

    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }
}