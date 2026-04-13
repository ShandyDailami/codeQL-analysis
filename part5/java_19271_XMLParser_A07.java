import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_19271_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("Person")) {
                return;
            }

            if (qName.equals("Name")) {
                bName = true;
                return;
            }

            if (qName.equals("Age")) {
                bAge = true;
                return;
            }

            // If we get here, we have an element that we didn't anticipate,
            // so ignore it.
            if (bName) {
                System.out.println("Name: " + attributes.getValue(""));
                bName = false;
            }

            if (bAge) {
                System.out.println("Age: " + attributes.getValue(""));
                bAge = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        try (FileInputStream fis = new FileInputStream("sample.xml")) {
            parser.parse(fis, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}