import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_03528_XMLParser_A08 extends DefaultHandler {
    private String lastTagName;

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            XMLParser handler = new XMLParser();
            saxParser.parse(new File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTagName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (lastTagName.equals(qName)) {
            System.out.println("End of " + qName + " tag");
        } else {
            System.out.println("Start of " + lastTagName + " tag");
        }
        lastTagName = "";
    }
}