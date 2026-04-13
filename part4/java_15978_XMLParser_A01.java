import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_15978_XMLParser_A01 extends DefaultHandler {
    private String lastTag;
    private String lastTagContent;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTag = qName;
        lastTagContent = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        lastTagContent += new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(lastTag + ": " + lastTagContent);
        lastTag = null;
        lastTagContent = null;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyXMLHandler handler = new MyXMLHandler();

        parser.parse(new File("input.xml"), handler);
    }
}