import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_19457_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            XMLHandler xmlHandler = new XMLHandler();
            saxParser.parse("src/resources/example.xml", xmlHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler implements javax.xml.parsers.SAXHandler {

    private boolean isName = false;
    private boolean isText = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {

        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("text")) {
            isText = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws javax.xml.parsers.SAXException {
        if (isName) {
            System.out.print("Name: ");
            isName = false;
        } else if (isText) {
            System.out.print("Text: ");
            isText = false;
        }

        System.out.println(new String(ch, start, length));
    }

}