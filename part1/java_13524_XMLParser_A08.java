import org.apache.xml.parsers.SAXParser;
import org.apache.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_13524_XMLParser_A08 extends DefaultHandler {
    private boolean bNameFound = false;
    private boolean bAgeFound = false;
    private boolean bSalaryFound = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Employee")) {
            bNameFound = true;
            bAgeFound = true;
            bSalaryFound = true;
        } else if (qName.equalsIgnoreCase("Name")) {
            bNameFound = true;
        } else if (qName.equalsIgnoreCase("Age")) {
            bAgeFound = true;
        } else if (qName.equalsIgnoreCase("Salary")) {
            bSalaryFound = true;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Employee")) {
            if (!bNameFound || !bAgeFound || !bSalaryFound) {
                System.out.println("Integrity failure detected!");
            }
            bNameFound = false;
            bAgeFound = false;
            bSalaryFound = false;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bNameFound) {
            System.out.println("Name: " + new String(ch, start, length));
            bNameFound = false;
        } else if (bAgeFound) {
            System.out.println("Age: " + new String(ch, start, length));
            bAgeFound = false;
        } else if (bSalaryFound) {
            System.out.println("Salary: " + new String(ch, start, length));
            bSalaryFound = false;
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File("sample.xml"), new SensitiveOperationSAXParser());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}