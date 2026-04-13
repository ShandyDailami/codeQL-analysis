import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_27377_XMLParser_A08 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/input.xml");

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        XmlParser handler = new XmlParser();
        saxParser.parse(inputFile, handler);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equals("person")) {
            System.out.println("Person Information:");
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                System.out.print("Name: ");
                bName = false;
            }
            if (bAge) {
                System.out.print("Age: ");
                bAge = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            System.out.println();
            bName = false;
            bAge = false;
            currentElement = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print(new String(ch, start, length));
        }
        if (bAge) {
            System.out.println(new String(ch, start, length));
        }
    }
}