import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_25791_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");
        SAXHandler myHandler = new SAXHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(myHandler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String name;
    private int age;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("Person")) {
            System.out.println("Start of Person : " + localName);
            bName = true;
            bAge = true;
        } else if (bName && qName.equalsIgnoreCase("Name")) {
            bName = false;
            System.out.println("Start of Name : " + localName);
        } else if (bName && qName.equalsIgnoreCase("Age")) {
            bAge = false;
            System.out.println("Start of Age : " + localName);
        } else if (bAge && qName.equalsIgnoreCase("Age")) {
            System.out.println("End of Age : " + localName);
            bAge = false;
        } else if (bAge && qName.equalsIgnoreCase("Name")) {
            System.out.println("End of Name : " + localName);
            bName = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("Person")) {
            System.out.println("End of Person : " + localName);
        } else if (qName.equalsIgnoreCase("Name")) {
            System.out.println("End of Name : " + localName);
        } else if (qName.equalsIgnoreCase("Age")) {
            System.out.println("End of Age : " + localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
            System.out.println("Name : " + name);
            bName = false;
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
            System.out.println("Age : " + age);
            bAge = false;
        }
    }
}