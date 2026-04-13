import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_36980_XMLParser_A01 {

    public static void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new SAXHandler(file));

        try {
            parser.parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
        private String file;

        public java_36980_XMLParser_A01(String file) {
            this.file = file;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (localName.equals("sensitiveData")) {
                // Only print out the file name and attributes, not the entire node
                System.out.println("File: " + file + ", Attributes: " + attributes);
            }
        }
    }
}