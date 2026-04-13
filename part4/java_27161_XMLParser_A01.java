import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_27161_XMLParser_A01 extends DefaultHandler {
    private String lastElement;
    private boolean bName;
    private boolean bAge;
    private boolean bSalary;

    public java_27161_XMLParser_A01() {
        bName = false;
        bAge = false;
        bSalary = false;
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;

        if(localName.equals("person")) {
            bName = true;
            bAge = true;
            bSalary = true;
        } else if (lastElement.equals("name")) {
            bName = true;
        } else if (lastElement.equals("age")) {
            bAge = true;
        } else if (lastElement.equals("salary")) {
            bSalary = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(localName.equals("person")) {
            bName = false;
            bAge = false;
            bSalary = false;
        } else if (lastElement.equals("name")) {
            bName = false;
        } else if (lastElement.equals("age")) {
            bAge = false;
        } else if (lastElement.equals("salary")) {
            bSalary = false;
        }

        lastElement = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if(bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        } else if (bSalary) {
            System.out.println("Salary: " + new String(ch, start, length));
        }
    }
}

public class TestSAX {
    public static void main(String[] args) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new MySAXHandler());
            xr.parse("people.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}