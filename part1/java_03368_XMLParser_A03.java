import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

import java.io.File;
import java.io.IOException;

public class java_03368_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();
            parser.parse(inputFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder elementData;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        elementData = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equals(qName)) {
            System.out.println("Element " + qName + ": " + elementData.toString());
        } else {
            System.out.println("End element " + currentElement + " with data: " + elementData.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementData.append(new String(ch, start, length));
    }
}