import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14981_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());

        try {
            parser.parse(new File("src/main/resources/sample.xml"), new MyHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("student")) {
            System.out.println("Name: " + attributes.getValue("name"));
            System.out.println("Age: " + attributes.getValue("age"));
            bName = true;
            bAge = true;
        } else if (bName && qName.equals("name")) {
            System.out.println("Name: " + attributes.getValue(""));
            bName = false;
        } else if (bAge && qName.equals("age")) {
            System.out.println("Age: " + attributes.getValue(""));
            bAge = false;
        }
    }
}