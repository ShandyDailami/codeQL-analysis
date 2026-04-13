import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_04584_XMLParser_A03 extends DefaultHandler {

    private String lastTagName;
    private boolean bName;
    private boolean bAge;
    private boolean bCountry;
    private String name;
    private int age;
    private String country;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTagName = qName;

        bName = qName.equals("person");
        bAge = qName.equals("age");
        bCountry = qName.equals("country");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            name = qName;
            bName = false;
        } else if (bAge) {
            age = Integer.parseInt(qName);
            bAge = false;
        } else if (bCountry) {
            country = qName;
            bCountry = false;
        } else {
            if (lastTagName.equals("person")) {
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Country: " + country);
            }
        }
    }

    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/input.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SecuritySAXParser handler = new SecuritySAXParser();
            saxParser.parse(inputFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}