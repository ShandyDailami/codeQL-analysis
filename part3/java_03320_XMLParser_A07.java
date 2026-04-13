import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03320_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("path_to_your_xml_file"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean isPerson;
    private boolean isFirstName;
    private boolean isLastName;
    private String currentValue;

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
        if (qName.equalsIgnoreCase("person")) {
            isPerson = true;
            isFirstName = false;
            isLastName = false;
            currentValue = "";
        } else if (isPerson && qName.equalsIgnoreCase("firstName")) {
            isFirstName = true;
        } else if (isPerson && qName.equalsIgnoreCase("lastName")) {
            isLastName = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            isPerson = false;
        } else if (isFirstName && qName.equalsIgnoreCase("firstName")) {
            isFirstName = false;
            System.out.println("First Name: " + currentValue);
        } else if (isLastName && qName.equalsIgnoreCase("lastName")) {
            isLastName = false;
            System.out.println("Last Name: " + currentValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isFirstName || isLastName) {
            currentValue = new String(ch, start, length);
        }
    }
}