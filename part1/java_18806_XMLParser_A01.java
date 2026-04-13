import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18806_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = parserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(inputFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bElementName = false;
    boolean bElementValue = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("element")) {
            bElementName = true;
            bElementValue = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("element")) {
            bElementName = false;
            bElementValue = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElementValue) {
            String elementValue = new String(ch, start, length);
            System.out.println("Value: " + elementValue);
            bElementValue = false;
        } else if (bElementName) {
            String elementName = new String(ch, start, length);
            System.out.println("Name: " + elementName);
        }
    }
}