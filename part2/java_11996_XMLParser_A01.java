import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11996_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("path_to_your_xml_file"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bElementName = false;
    String elementName = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        bElementName = true;
        elementName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElementName = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElementName) {
            String elementContent = new String(ch, start, length).trim();
            if (!elementContent.isEmpty()) {
                System.out.println(elementName + ": " + elementContent);
            }
        }
    }
}