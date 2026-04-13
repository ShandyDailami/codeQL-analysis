import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_09578_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private String currentElement = "";
    private String name = "";
    private String age = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;

        if (qName.equals("person")) {
            bName = true;
            bAge = true;
        } else {
            if (bName) {
                if (currentElement.equals("name")) {
                    bName = false;
                } else {
                    bName = false;
                }
            } else if (bAge) {
                if (currentElement.equals("age")) {
                    bAge = false;
                } else {
                    bAge = false;
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        } else if (bAge) {
            age = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person")) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        File xmlFile = new File("src/data.xml");
        MyHandler myHandler = new MyHandler();

        try {
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(myHandler);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}