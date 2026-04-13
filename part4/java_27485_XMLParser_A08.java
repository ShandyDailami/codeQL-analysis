import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27485_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        // Create an instance of the handler
        MyHandler myHandler = new MyHandler();

        // Parse the XML file
        saxParser.parse(new File("path_to_your_file.xml"), myHandler);
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else if (bName && qName.equals("name")) {
            bName = false;
        } else if (bName && qName.equals("age")) {
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName && currentElement.equals("name")) {
            // Check for integrity failure in the name (length should be less than 100 characters)
            String name = new String(ch, start, length);
            if (name.length() > 100) {
                System.out.println("Error: Name is too long");
            }
        } else if (bAge && currentElement.equals("age")) {
            // Check for integrity failure in the age (age should be a positive integer)
            String age = new String(ch, start, length);
            int ageInt = 0;
            try {
                ageInt = Integer.parseInt(age);
            } catch (NumberFormatException e) {
                System.out.println("Error: Age is not a valid integer");
            }
            if (ageInt < 0) {
                System.out.println("Error: Age is not a positive integer");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
        if (qName.equals("person")) {
            bName = false;
            bAge = false;
        }
    }
}