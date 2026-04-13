import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_31825_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/main/resources/example.xml", myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    private boolean bName;
    private boolean bAge;
    private String tempValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("person")) {
            bName = true;
            bAge = true;
        }

        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        }

        if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("person")) {
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            tempValue = new String(ch, start, length);
            System.out.println("Name: " + tempValue);
            bName = false;
        } else if (bAge) {
            tempValue = new String(ch, start, length);
            System.out.println("Age: " + tempValue);
            bAge = false;
        }
    }
}