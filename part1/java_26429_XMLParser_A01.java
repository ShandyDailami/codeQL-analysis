import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_26429_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            parser.parse(new File("src/main/resources/example.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class XmlHandler extends DefaultHandler {
    private StringBuilder buffer = new StringBuilder();
    private boolean element = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = true;
        buffer.setLength(0);
        buffer.append("<").append(qName);
        if (attributes.getLength() > 0) {
            buffer.append(" ");
            for (int i = 0; i < attributes.getLength(); i++) {
                buffer.append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\" ");
            }
        }
        buffer.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (element) {
            element = false;
            buffer.append("</").append(qName).append(">");
            System.out.println(buffer.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element) {
            buffer.append(new String(ch, start, length));
        }
    }
}