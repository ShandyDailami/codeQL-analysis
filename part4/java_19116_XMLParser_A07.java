import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_19116_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("src/input.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
                System.out.println("Name  " + " Age");
                return;
            }
            if (bName) {
                System.out.print("Name: ");
                bName = false;
            }
            if (bAge) {
                System.out.println("Age");
                bAge = false;
            }
            if (qName.equalsIgnoreCase("name")) {
                System.out.print(attributes.getValue(""));
            }
            if (qName.equalsIgnoreCase("age")) {
                System.out.println(" - Age: " + attributes.getValue(""));
            }
        }
    }
}