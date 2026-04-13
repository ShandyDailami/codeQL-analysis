import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_38725_XMLParser_A08 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCountry = false;

    private String name = null;
    private String age = null;
    private String country = null;

    public static void main(String[] args) {
        String file = "src/test.xml";
        XMLParser parser = new XMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null);
            saxParser.parse(file, parser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Name: " + parser.getName());
        System.out.println("Age: " + parser.getAge());
        System.out.println("Country: " + parser.getCountry());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            // start of 'person' element
            bName = true;
            bAge = true;
            bCountry = true;
        } else if (bName) {
            name = localName;
            bName = false;
        } else if (bAge) {
            age = localName;
            bAge = false;
        } else if (bCountry) {
            country = localName;
            bCountry = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            // end of 'person' element
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Country: " + country);

            name = null;
            age = null;
            country = null;
        }
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}