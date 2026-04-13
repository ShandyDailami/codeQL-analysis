import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01141_XMLParser_A08 extends DefaultHandler {
    private boolean bName;
    private String strName;

    public java_01141_XMLParser_A08() {
        bName = false;
        strName = "";
    }

    public void startElement(String uri, String localName, String qName,
            String version) {
        bName = true;
        strName = qName;
    }

    public void endElement(String uri, String localName, String qName) {
        bName = false;
    }

    public void characters(char[] ch, int start, int length) {
        if (bName) {
            strName = strName + new String(ch, start, length);
        }
    }

    public void integrityFailure(String error, String hint) {
        System.out.println("Integrity failure: " + error);
        System.out.println("Hint: " + hint);
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.setContentHandler(new XMLParser());
            parser.parse(inputFile, new SAXSource(new XMLReader()));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}