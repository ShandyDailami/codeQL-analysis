import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16242_XMLParser_A08 extends DefaultHandler {

    private boolean bTag = false;
    private String currentElement = "";
    private String currentValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        bTag = true;
        currentValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
        if(currentElement.equals(qName)) {
            System.out.println(currentElement + " : " + currentValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bTag) {
            currentValue = new String(ch, start, length);
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/sample.xml");

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = parserFactory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            parser.parse(inputFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}