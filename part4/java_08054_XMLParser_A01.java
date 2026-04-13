import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_08054_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {

    private boolean isEmployee = false;
    private String employeeName;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            isEmployee = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {

        if (qName.equalsIgnoreCase("employee")) {
            isEmployee = false;
        } else if (isEmployee) {
            employeeName = qName;
            // Process employee name here...
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        if (isEmployee) {
            // Add the character data to employeeName variable.
        }
    }
}