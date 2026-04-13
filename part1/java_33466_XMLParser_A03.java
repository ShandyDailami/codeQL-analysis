import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_33466_XMLParser_A03 {

    public static void parseFile(String filename) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // Use DefaultHandler to suppress default behavior
        parser.parse(new File(filename), new DefaultHandler() {
            boolean isInElement = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                isInElement = true;
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                isInElement = false;
                System.out.println("End element: " + qName);
           
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isInElement) {
                    System.out.println("Characters: " + new String(ch, start, length));
                }
            }
        });
    }

    public static void main(String[] args) {
        parseFile("sample.xml");
    }
}