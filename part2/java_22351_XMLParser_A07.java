import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_22351_XMLParser_A07 {
    private DefaultHandler handler;

    public java_22351_XMLParser_A07() {
        handler = new DefaultHandler();
    }

    public void parse(String filename) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new InputSource(new File(filename)));

            parser.setContentHandler(handler);
            parser.parse(new File(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("input.xml");
    }
}