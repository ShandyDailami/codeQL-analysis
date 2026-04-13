import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16978_XMLParser_A03 extends DefaultHandler {
    boolean bElementName = false;
    boolean bElementValue = false;
    String elementValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("element")) {
            bElementName = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElementName) {
            bElementName = false;
            String elementName = new String(ch, start, length);
            System.out.println("Element Name: " + elementName);
        } else if (bElementValue) {
            bElementValue = false;
            elementValue = new String(ch, start, length);
            System.out.println("Element Value: " + elementValue);
        }
    }
}

public class MySAXParser {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}