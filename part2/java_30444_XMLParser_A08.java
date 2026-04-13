import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_30444_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {
        System.out.println("Start element: " + qName);
        // TODO: Implement security-sensitive operations related to A08_IntegrityFailure.
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
        // TODO: Implement security-sensitive operations related to A08_IntegrityFailure.
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
        // TODO: Implement security-sensitive operations related to A08_IntegrityFailure.
    }
}