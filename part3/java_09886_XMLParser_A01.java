import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_09886_XMLParser_A01 {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // Create a new MyHandler to handle XML data
        MyHandler handler = new MyHandler();

        // Parse the XML document
        parser.parse(new File("myfile.xml"), handler);
    }
}

class MyHandler extends DefaultHandler {
    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElement = qName;

        System.out.println("Start element: " + qName);

        // Print attributes if any
        int count = attributes.getLength();
        for (int i = 0; i < count; i++) {
            System.out.println("Attribute: " + attributes.getQName(i) + " = " + attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastElement = null;

        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }
}