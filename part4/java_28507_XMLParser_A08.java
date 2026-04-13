import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_28507_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            MyHandler myHandler = new MyHandler();
            saxParser.parse(Main.class.getResourceAsStream("/sample.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyHandler extends DefaultHandler {

    private StringBuilder data;
    private int depth;

    @Override
    public void startDocument() {
        data = new StringBuilder();
        depth = 0;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data.setLength(0);
        depth++;
        if (depth > 1) {
            data.append(localName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        depth--;
        if (depth > 1) {
            data.append(localName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (depth == 1) {
            data.append(new String(ch, start, length));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("XML Data: " + data);
    }

}