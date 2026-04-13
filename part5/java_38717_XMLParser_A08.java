import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;

public class java_38717_XMLParser_A08 extends DefaultHandler {

    private String lastElement;
    private boolean bName;
    private boolean bAge;
    private boolean bSalary;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        lastElement = qName;

        if (qName.equalsIgnoreCase("employee")) {
            bName = true;
            bAge = true;
            bSalary = true;
        } else {
            if (bName && qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (bName && qName.equalsIgnoreCase("age")) {
                bAge = false;
            } else if (bName && qName.equalsIgnoreCase("salary")) {
                bSalary = false;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            bName = false;
            bAge = false;
            bSalary = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        } else if (bSalary) {
            System.out.println("Salary: " + new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(inputFile, MyHandler.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}