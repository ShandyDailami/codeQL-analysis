import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_16357_XMLParser_A01 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();

    public void startDocument() {
        System.out.println("Start of Document");
    }

    public void endDocument() {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        tags.add(qName);
        System.out.println("Start Element: " + qName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + qName);
        tags.remove(qName);
    }

    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if(content.isEmpty()){
            return;
        }
        String tag = tags.get(tags.size()-1);
        System.out.println("Character Data: " + content + " in Tag: " + tag);
    }

    public void fatalError(String error) {
        System.out.println("Fatal Error: " + error);
    }

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        XmlParser handler = new XmlParser();
        org.xml.sax.SAXParserFactory factory = org.xml.sax.SAXParserFactory.newInstance();
        try {
            org.xml.sax.SAXParser saxParser = factory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}