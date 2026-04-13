import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_37287_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new File("input.xml"), XmlHandler.getValidation());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {
        private static boolean validation = false;

        public static boolean getValidation() {
            return validation;
        }

        public static void setValidation(boolean validation) {
            XmlHandler.validation = validation;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start Element: " + qName);
            if (validation) {
                // Validation code here.
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
            if (validation) {
                // Validation code here.
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Characters: " + new String(ch, start, length));
            if (validation) {
                // Validation code here.
            }
        }
    }
}