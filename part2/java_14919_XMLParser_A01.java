import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.SAXReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_14919_XMLParser_A01 {

    public static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            System.out.println("Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End Element: " + qName);
        }
    }

    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            reader.setContentHandler(new MyHandler());
            reader.setValidation(true);
            reader.validate(new File("brokenAccessControl.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}