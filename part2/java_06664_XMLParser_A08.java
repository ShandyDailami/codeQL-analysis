import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_06664_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            File xmlFile = new File("input.xml"); // replace with your xml file path
            XMLHandler xmlHandler = new XMLHandler();

            saxParser.parse(xmlFile, xmlHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {
    boolean isStartElement = true;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {
        if (isStartElement) {
            isStartElement = false;
            System.out.println("Start Element: " + qName);
        } else {
            System.out.println("Element Data: " + attributes.getValue(0).getValue());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isStartElement) {
            System.out.println("Element Data: " + new String(ch, start, length));
        }
    }
}