import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_33306_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            Handler handler = new Handler();
            saxParser.parse(new File("resources/sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class Handler extends DefaultHandler {
        boolean bName = false;
        boolean bValue = false;
        String name = "";
        String value = "";

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("value")) {
                bValue = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("value")) {
                bValue = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (bName) {
                name = new String(ch, start, length);
            } else if (bValue) {
                value = new String(ch, start, length);
                System.out.println("Name: " + name + ", Value: " + value);
            }
        }
    }
}