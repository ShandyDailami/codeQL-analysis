import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_18605_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Disable access control
            saxParser.getXMLReader().setFeature("http://xml.org/sax/features/external-general-entities", false);
            saxParser.getXMLReader().setFeature("http://xml.org/sax/features/external-dtd", false);
            saxParser.getXMLReader().setFeature("http://xml.org/sax/features/namespaces", false);

            // Parse the XML file
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends javax.xml.parsers.SAXHandler {
    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws javax.xml.parsers.SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}