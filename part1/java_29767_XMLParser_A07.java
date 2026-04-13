import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_29767_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler(xml));
            saxParser.parse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuffer buffer;
    private boolean isInElement = false;
    private String currentElement;

    public java_29767_XMLParser_A07(String xml) {
        buffer = new StringBuffer();
        parseXml(xml);
    }

    private void parseXml(String xml) {
        xml.split("").forEach(char -> {
            buffer.append(char);
        });
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        buffer.append("Start element: " + qName + "\n");
        isInElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        buffer.append("End element: " + qName + "\n");
        isInElement = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isInElement) {
            buffer.append(new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() {
        buffer.append("End document\n");
    }

    public String getBuffer() {
        return buffer.toString();
    }
}