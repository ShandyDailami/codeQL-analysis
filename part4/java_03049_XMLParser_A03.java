import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_03049_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new XMLHandler());
            File inputFile = new File("input.xml");
            saxParser.parse(inputFile, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes)
            throws javax.xml.parsers.SAXException {
        // This method is called when an element is started.
        // You can put your security-sensitive operations here.
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        // This method is called when an element is ended.
        // You can put your security-sensitive operations here.
        System.out.println("End of element: " + qName);
    }
}