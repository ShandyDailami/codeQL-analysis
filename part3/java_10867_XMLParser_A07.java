import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_10867_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create an instance of the XMLReader
            XMLReader xr = XMLReaderFactory.createXMLReader();
            
            // Set the content handler to parse the XML file
            xr.setContentHandler(new MyContentHandler());
            
            // Parse the XML file
            xr.parse("example.xml");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements ContentHandler {
    private boolean inPerson;
    private boolean inName;
    private boolean inAge;
    private String name;
    private int age;

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            inPerson = true;
            inName = false;
            inAge = false;
            name = "";
            age = 0;
        } else if (qName.equalsIgnoreCase("name")) {
            inName = true;
            inPerson = false;
            inAge = false;
        } else if (qName.equalsIgnoreCase("age")) {
            inAge = true;
            inPerson = false;
            inName = false;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            inPerson = false;
            System.out.println("Person: " + name + ", Age: " + age);
        } else if (qName.equalsIgnoreCase("name")) {
            inName = false;
        } else if (qName.equalsIgnoreCase("age")) {
            inAge = false;
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (inPerson) {
            name = new String(ch, start, length);
        } else if (inAge) {
            age = Integer.parseInt(new String(ch, start, length));
        }
    }
}