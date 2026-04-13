import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_34578_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser();

            File inputFile = new File("input.xml");
            InputSource source = new StreamSource(inputFile);

            MyHandler handler = new MyHandler();
            saxParser.parse(source, handler);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements ContentHandler {
    boolean bElement = false;
    String sElementValue = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElement = true;
        sElementValue = "";
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;

        if (qName.equals("element")) {
            System.out.println("Element Value: " + sElementValue);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            sElementValue = new String(ch, start, length);
        }
    }
}