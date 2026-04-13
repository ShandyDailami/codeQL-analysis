import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_38903_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("src/main/resources/sample.xml"), myHandler);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.SAXHandler {

    private String name;
    private String text;

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) {
        if ("name".equals(qName)) {
            this.name = attributes.getValue("");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        this.text = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("name".equals(qName)) {
            System.out.println("Name: " + this.name + ", Text: " + this.text);
        }
    }
}