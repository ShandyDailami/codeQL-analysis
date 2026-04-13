import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_32857_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String name;
    private String age;

    public java_32857_XMLParser_A08() {
    }

    public void startDocument() {
        System.out.println("Start of document");
    }

    public void endDocument() {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = false;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bName) {
            name = new String(ch, start, length);
            System.out.println("Name: " + name);
            bName = false;
        } else if (bAge) {
            age = new String(ch, start, length);
            System.out.println("Age: " + age);
            bAge = false;
        }
    }

    public static void main(String[] args) {
        String fileName = "sample.xml";
        File file = new File(fileName);

        XMLParser handler = new XMLParser();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(file, handler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}