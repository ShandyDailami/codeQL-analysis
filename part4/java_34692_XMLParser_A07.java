import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34692_XMLParser_A07 extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;
    private String qName = "";
    private int qAge = 0;
    
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyXMLParser myHandler = new MyXMLParser();
            saxParser.parse(Class.forName("MyFile").getResourceAsStream("sample.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        this.qName = qName;
        if (qName.equals("student")) {
            bName = true;
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("name")) {
            bName = false;
        } else if (qName.equals("age")) {
            bAge = false;
        } else if (qName.equals("student")) {
            // process student
            System.out.println("Name: " + this.qName + ", Age: " + this.qAge);
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bName) {
            this.qName = new String(ch, start, length);
        } else if (bAge) {
            this.qAge = Integer.parseInt(new String(ch, start, length));
        }
    }
}