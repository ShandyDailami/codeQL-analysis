import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_20515_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse(new File("sample.xml"), xmlHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler implements javax.xml.parsers.SAXHandler {
    private boolean nameFound = false;
    private boolean ageFound = false;

    private String name = null;
    private int age = 0;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) {
        if (qName.equalsIgnoreCase("name")) {
            this.nameFound = true;
        } else if (qName.equalsIgnoreCase("age")) {
            this.ageFound = true;
        }
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        if (this.nameFound) {
            this.name = new String(chars, start, length);
            this.nameFound = false;
        } else if (this.ageFound) {
            this.age = Integer.parseInt(new String(chars, start, length));
            this.ageFound = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("name")) {
            System.out.println("Name: " + this.name);
        } else if (qName.equalsIgnoreCase("age")) {
            System.out.println("Age: " + this.age);
        }
    }
}