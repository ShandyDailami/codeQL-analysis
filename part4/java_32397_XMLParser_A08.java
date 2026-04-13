import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.Iterator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_32397_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);

            DefaultHandler handler = new DefaultHandler() {
                boolean bName = false;
                boolean bAge = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if ("person".equals(qName)) {
                        bName = true;
                        bAge = true;
                    } else if (bName) {
                        bName = false;
                        System.out.println("Name: " + attributes.getValue("name"));
                    } else if (bAge) {
                        bAge = false;
                        System.out.println("Age: " + attributes.getValue("age"));
                    }
                }
            };

            parser.parse(new FileInputStream(new File("src/main/resources/people.xml")), handler);

        } catch (FileNotFoundException | SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}