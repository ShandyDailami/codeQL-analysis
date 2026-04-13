import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_35945_XMLParser_A03 extends DefaultHandler {

    private String lastElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null && lastElement.equalsIgnoreCase("person")) {
            System.out.println(new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<people>\n" +
                "   <person id=\"1\">\n" +
                "      <name>John</name>\n" +
                "      <city>New York</city>\n" +
                "   </person>\n" +
                "   <person id=\"2\">\n" +
                "      <name>Mary</name>\n" +
                "      <city>San Francisco</city>\n" +
                "   </person>\n" +
                "</people>";

        XmlSAXHandler handler = new XmlSAXHandler();
        org.xml.sax.SAXParserFactory saxParserFactory = org.xml.sax.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(false);
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}