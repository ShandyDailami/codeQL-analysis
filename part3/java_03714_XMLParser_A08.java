import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_03714_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

            // parse the xml file
            saxParser.parse(new File("src/main/resources/sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bFirstName = true;
        boolean bLastName = true;
        boolean bAge = true;
        String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            currentElement = qName;

            if (currentElement.equalsIgnoreCase("FirstName")) {
                bFirstName = false;
            } else if (currentElement.equalsIgnoreCase("LastName")) {
                bLastName = false;
            } else if (currentElement.equalsIgnoreCase("Age")) {
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("FirstName")) {
                bFirstName = true;
            } else if (qName.equalsIgnoreCase("LastName")) {
                bLastName = true;
            } else if (qName.equalsIgnoreCase("Age")) {
                bAge = true;
            }

            currentElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bFirstName && !currentElement.equals("")) {
                System.out.println("First Name: " + new String(ch, start, length));
            } else if (bLastName && !currentElement.equals("")) {
                System.out.println("Last Name: " + new String(ch, start, length));
            } else if (bAge && !currentElement.equals("")) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}