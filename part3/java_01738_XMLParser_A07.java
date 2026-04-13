import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_01738_XMLParser_A07 extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print("Start element: " + qName);
        if (attributes.getLength() > 0) {
            System.out.print(" Attributes: ");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print(attributes.getQName(i) + "=" + attributes.getValue(i));
                if (i < attributes.getLength() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Characters: " + content);
    }
}

public class Main {
    public static void main(String[] args) {
        String fileName = "authFailure.xml";

        File inputFile = new File(fileName);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new FileInputStream(inputFile)));
            MyHandler myHandler = new MyHandler();
            saxParser.parse(inputFile, myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}