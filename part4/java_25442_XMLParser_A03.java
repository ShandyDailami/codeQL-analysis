import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.SAXReader;

import java.io.File;
import java.io.IOException;

public class java_25442_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;

    private String name;
    private int age;

    public java_25442_XMLParser_A03() {
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("person")) {
            return;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = true;
            return;
        }

        if (qName.equalsIgnoreCase("age")) {
            bAge = true;
            return;
        }

        // Start of security-sensitive operation: Injection
        if (bName && bAge) {
            String s = attributes.getValue("name");
            int a = Integer.parseInt(attributes.getValue("age"));

            // Do something with s and a
            System.out.println("Name: " + s + ", Age: " + a);

            bName = false;
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (qName.equalsIgnoreCase("person")) {
            return;
        }
    }

    public static void main(String[] args) {

        File inputFile = new File("src/sample.xml");

        SAXReader reader = new SAXReader();

        try {
            XMLReader xmlReader = reader.getReader(inputFile);
            xmlReader.setContentHandler(new MyXMLHandler());
            xmlReader.parse(inputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}