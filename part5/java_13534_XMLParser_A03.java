import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_13534_XMLParser_A03 extends DefaultHandler {

    private boolean bName = false;
    private boolean bAge = false;
    private boolean bCountry = false;
    private String name = null;
    private int age = 0;
    private String country = null;

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(true);
            saxParser.parse("src/people.xml", parser);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("person")) {
            // create new person
        } else if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("age")) {
            bAge = true;
        } else if (qName.equals("country")) {
            bCountry = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            name = new String(ch, start, length);
            bName = false;
        } else if (bAge) {
            age = Integer.parseInt(new String(ch, start, length));
            bAge = false;
        } else if (bCountry) {
            country = new String(ch, start, length);
            bCountry = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("person")) {
            // process person
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Country: " + country);
        }
    }
}