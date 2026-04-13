import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_22969_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // Create a new handler
        MyHandler handler = new MyHandler();

        try {
            // Parse the XML file
            parser.parse(new File("path_to_your_xml_file.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isItem = false;
    private boolean isName = false;
    private boolean isQuantity = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            isItem = true;
        } else if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("quantity")) {
            isQuantity = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            isItem = false;
        } else if (qName.equalsIgnoreCase("name")) {
            isName = false;
        } else if (qName.equalsIgnoreCase("quantity")) {
            isQuantity = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isItem) {
            System.out.println("Item: " + new String(ch, start, length));
        } else if (isName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (isQuantity) {
            System.out.println("Quantity: " + new String(ch, start, length));
        }
    }
}