import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;

public class java_09497_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // provide your xml file
        try {
            parseXMLFile(xmlFile);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFile(String xmlFile) throws IOException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        MyHandler handler = new MyHandler();
        reader.setContentHandler(handler);
        reader.parse(xmlFile);
    }

    private static class MyHandler extends DefaultHandler {
        private boolean inName;
        private String name;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                inName = true;
                name = "";
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inName) {
                name = new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                // Security-sensitive operation: use of string 'name' in unexpected situations.
                // For example, it could be used in a SQL query or a file path.
                // Use appropriate sanitization techniques to prevent injection attacks.
                // The following line is just for demonstration purposes.
                System.out.println("Injecting name: " + name);
                // Do nothing for now. Remove when you're ready for actual injection.
            }
        }
    }
}