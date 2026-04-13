import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27340_XMLParser_A03 {

    public static void main(String[] args) {
        String filePath = "your_file_path.xml";  // replace with your XML file path
        parseXML(filePath);
    }

    private static void parseXML(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse(new File(filePath), Handler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends DefaultHandler {

        private boolean isName = false;
        private boolean isAttribute = false;
        private boolean isValue = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("attribute")) {
                isAttribute = true;
            } else if (qName.equalsIgnoreCase("value")) {
                isValue = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                System.out.print("Name: ");
                isName = false;
            } else if (isAttribute) {
                System.out.print("Attribute: ");
                isAttribute = false;
            } else if (isValue) {
                System.out.print("Value: ");
                isValue = false;
            }
        }
    }
}