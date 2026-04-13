import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

public class java_27060_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(new InputSource(new FileInputStream(inputFile)));
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("note".equals(qName)) {
            System.out.println("-------------------------------");
            bName = true;
            bAge = true;
            currentElement = qName;
        } else if (bName) {
            System.out.println("Name: " + localName);
            bName = false;
        } else if (bAge) {
            System.out.println("Age: " + attributes.getValue(0));
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("note".equals(qName)) {
            currentElement = "";
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.print("Note: " + new String(ch, start, length));
        }
    }
}