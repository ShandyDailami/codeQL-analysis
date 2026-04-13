import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_33639_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            // Create an instance of the Handler
            XMLHandler handler = new XMLHandler();
            parser.parse(new File("books.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Define the handler for the SAX parser
class XMLHandler implements javax.xml.parsers.SAXHandler {
    private boolean isBook = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {
        isBook = (qName.equals("book"));
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isBook) {
            System.out.println("Book name: " + currentElement);
            isBook = false;
        }
    }
}