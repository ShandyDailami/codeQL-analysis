import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_32137_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a handler that only prints out the element names
            MyHandler handler = new MyHandler();
            builder.setContentHandler(handler);

            XMLReader reader = builder.newSAXReader();
            reader.setContentHandler(handler);

            Document doc = builder.parse("example.xml"); // replace with your XML file

            // Print the element names
            handler.printElements();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a handler that only prints out the element names
    static class MyHandler extends DefaultHandler {
        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (lastElementName.equals(qName)) {
                System.out.println("Element: " + lastElementName);
            }
        }

        public void printElements() {
            System.out.println("Printing element names...");
            // Print the element names here
        }
    }
}