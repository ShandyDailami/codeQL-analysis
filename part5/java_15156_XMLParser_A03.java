import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_15156_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        parseFile(fileName);
    }

    private static void parseFile(String fileName) {
        File inputFile = new File(fileName);
        SAXParser saxParser = new SAXParser();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxParser);
            reader.parse(inputFile);
        } catch (SAXParseException e) {
            System.out.println("Parsing failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Failed to read file: " + e.getMessage());
        }
    }
}

class SAXParser extends DefaultHandler {
    private boolean isEmployee;
    private boolean isName;
    private boolean isPosition;
    private boolean isSalary;

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
        if (qName.equalsIgnoreCase("Employee")) {
            isEmployee = true;
            isName = false;
            isPosition = false;
            isSalary = false;
        } else if (qName.equalsIgnoreCase("Name")) {
            isName = true;
            isEmployee = false;
            isPosition = false;
            isSalary = false;
        } else if (qName.equalsIgnoreCase("Position")) {
            isPosition = true;
            isEmployee = false;
            isName = false;
            isSalary = false;
        } else if (qName.equalsIgnoreCase("Salary")) {
            isSalary = true;
            isEmployee = false;
            isName = false;
            isPosition = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Employee")) {
            isEmployee = false;
            isName = false;
            isPosition = false;
            isSalary = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isEmployee) {
            System.out.println("Employee: " + new String(ch, start, length));
        } else if (isName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (isPosition) {
            System.out.println("Position: " + new String(ch, start, length));
        } else if (isSalary) {
            System.out.println("Salary: " + new String(ch, start, length));
        }
    }
}