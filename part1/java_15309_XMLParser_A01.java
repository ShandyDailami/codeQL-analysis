import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15309_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);

            XMLHandler handler = new XMLHandler();
            saxParser.parse(new File("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XMLHandler extends DefaultHandler {

    private boolean bTag = false;
    private String currentTag = "";
    private String currentValue = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTag = qName;
        bTag = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bTag) {
            currentValue = new String(ch, start, length);
            bTag = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (currentTag.equalsIgnoreCase(qName)) {
            System.out.println("End of " + currentTag);
            System.out.println("Value: " + currentValue);
            currentTag = "";
        }
    }
}