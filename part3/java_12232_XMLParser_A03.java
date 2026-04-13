import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_12232_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());

            // Parsing XML file
            File inputFile = new File("input.xml");
            saxParser.parse(inputFile, false);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bName = false;
    boolean bValue = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("element")) {
            bName = true;
            bValue = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            String sElementName = new String(ch, start, length);
            System.out.println("Element Name: " + sElementName);
            bName = false;
        } else if (bValue) {
            String sElementValue = new String(ch, start, length);
            System.out.println("Element Value: " + sElementValue);
            bValue = false;
        }
    }
}