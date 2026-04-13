import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_06156_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);

            System.out.println("Done.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends javax.xml.parsers.ContentHandler {
    private String currentElement = "";
    private String currentElementValue = "";
    private boolean inElement = false;

    public void startElement(String uri, String localName, String qName,
        javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        if (!qName.equalsIgnoreCase(currentElement)) {
            currentElement = qName;
            currentElementValue = "";
            inElement = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
        throws javax.xml.parsers.SAXException {
        if (qName.equalsIgnoreCase(currentElement)) {
            currentElement = "";
            inElement = false;
            if (currentElementValue.startsWith("<security>") && currentElementValue.endsWith("</security>")) {
                // Security sensitive operation related to A08_IntegrityFailure
                System.out.println("Security Sensitive operation related to A08_IntegrityFailure: " + currentElementValue);
            }
        }
    }

    public void characters(char ch[], int start, int length)
        throws javax.xml.parsers.SAXException {
        if (inElement) {
            currentElementValue = new String(ch, start, length);
        }
    }
}