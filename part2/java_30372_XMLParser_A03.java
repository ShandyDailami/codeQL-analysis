import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_30372_XMLParser_A03 {
    public static void main(String[] args) {
        String inputFile = "example.xml"; // File to parse
        parse(inputFile);
    }

    private static void parse(String inputFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new InputStreamSource(new FileInputStream(new File(inputFile))));
            MyHandler handler = new MyHandler();
            parser.parse(new InputSource(new File(inputFile)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean inPerson = false;
        private boolean inFirstName = false;
        private boolean inLastName = false;
        private boolean inAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            switch (qName) {
                case "person":
                    inPerson = true;
                    break;
                case "firstName":
                    inFirstName = true;
                    break;
                case "lastName":
                    inLastName = true;
                    break;
                case "age":
                    inAge = true;
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                inPerson = false;
            } else if (qName.equals("firstName")) {
                inFirstName = false;
            } else if (qName.equals("lastName")) {
                inLastName = false;
            } else if (qName.equals("age")) {
                inAge = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (inPerson) {
                // Handle person element
                // Here you can implement injection attacks
            } else if (inFirstName) {
                // Handle firstName element
                // Here you can implement injection attacks
            } else if (inLastName) {
                // Handle lastName element
                // Here you can implement injection attacks
            } else if (inAge) {
                // Handle age element
                // Here you can implement injection attacks
            }
        }
    }
}