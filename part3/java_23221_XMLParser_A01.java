import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23221_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null);

            MyHandler handler = new MyHandler();
            XMLReader reader = parser.getXMLReader(handler);
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", false);

            File xmlFile = new File("example.xml");
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private StringBuilder buffer;
    private boolean isTitle;

    public java_23221_XMLParser_A01() {
        buffer = new StringBuilder();
        isTitle = false;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        buffer.setLength(0);
        isTitle = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isTitle) {
            isTitle = false;
            System.out.println("Title: " + buffer.toString());
        } else if (!qName.equals("page")) {
            System.out.println("Page: " + buffer.toString());
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitle) {
            buffer.append(new String(ch, start, length));
        }
    }
}