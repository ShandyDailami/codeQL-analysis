import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;

import java.io.File;
import java.io.IOException;

public class java_20552_XMLParser_A01 extends DefaultHandler {

    private StringBuilder data = new StringBuilder();
    private boolean bElement = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data.setLength(0);
        bElement = true;
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            data.append(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
        if (currentElement.equalsIgnoreCase("person")) {
            System.out.println("Name: " + data.toString());
        }
    }
}

public class Main {

    public static void main(String[] args) {

        File inputFile = new File("src/main/resources/sample.xml");
        SAXReader reader = new SAXReader();

        try {
            reader.setContentHandler(new MyXMLHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}