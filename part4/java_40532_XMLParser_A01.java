import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40532_XMLParser_A01 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Parsing person element...");
            bName = true;
            bAge = true;
        } else if (bName) {
            System.out.print("Name: ");
            bName = false;
        } else if (bAge) {
            System.out.print("Age: ");
            bAge = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Finished parsing person element");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            System.out.println(new String(ch, start, length));
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);
            MySAXHandler mySAXHandler = new MySAXHandler();
            saxParser.parse(Main.class.getResourceAsStream("people.xml"), mySAXHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}