import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_21575_XMLParser_A03 {
    private static class XmlHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // Check for injection attempts
            if (localName.equals("username") && attributes.getValue("password") != null) {
                System.out.println("Password found in XML document!");
            }
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("path/to/input/file.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(inputFile, XmlHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}