import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_08524_XMLParser_A08 extends DefaultHandler {

    private StringBuilder data;

    @Override
    public void startDocument() {
        data = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data.append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            data.append(" ").append(attributes.getQualifiedName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }
        data.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        data.append("</").append(qName).append(">");
    }

    @Override
    public void endDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("example.xml"), this);
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}