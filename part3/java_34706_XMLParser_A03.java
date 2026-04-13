import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34706_XMLParser_A03 {

    public static class MyHandler extends DefaultHandler {
        private String thisElement;
        private StringBuilder data = new StringBuilder();

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            thisElement = qName;
            data.setLength(0);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (thisElement.equalsIgnoreCase("name")) {
                String name = data.toString();
                // Security-sensitive operation related to injection attack
                // Example: Inject the SQL query into the database.
                // In the real world scenario, this operation should be performed in a separate service layer.
                System.out.println("SQL Injection attempt: " + name);
            } else {
                data.append(qName);
            }
            thisElement = "";
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        File inputFile = new File("src/main/resources/sample.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(inputFile, handler);
    }
}