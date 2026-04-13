import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_10899_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();

            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);

            // Parse the XML file
            parser.parse(new File("sample.xml"), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean inPerson = false;
    private boolean inAge = false;
    private boolean inSalary = false;

    private String currentElement;

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("Start element: " + qName);
        currentElement = qName;

        if (qName.equals("Person")) {
            inPerson = true;
        }
        else if (qName.equals("Age")) {
            inAge = true;
        }
        else if (qName.equals("Salary")) {
            inSalary = true;
        }
    }

    @Override
    public java_10899_XMLParser_A03(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
        currentElement = null;

        if (qName.equals("Person")) {
            inPerson = false;
        }
        else if (qName.equals("Age")) {
            inAge = false;
        }
        else if (qName.equals("Salary")) {
            inSalary = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (inPerson) {
            System.out.println("Person's name: " + new String(ch, start, length));
        }
        else if (inAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
        else if (inSalary) {
            System.out.println("Salary: " + new String(ch, start, length));
        }
    }
}