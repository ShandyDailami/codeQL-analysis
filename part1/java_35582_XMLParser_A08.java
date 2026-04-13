import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_35582_XMLParser_A08 {
    public static void main(String[] args) {
        // Create a new SAX parser factory
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // Create a new SAX parser
        SAXParser parser = factory.newSAXParser();

        // Create a new handler
        MyHandler handler = new MyHandler();

        // Parse the XML file
        try {
            parser.parse(new File("src/myfile.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean isInElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        isInElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        isInElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isInElement) {
            String str = new String(ch, start, length);
            System.out.println(str);
        }
    }
}